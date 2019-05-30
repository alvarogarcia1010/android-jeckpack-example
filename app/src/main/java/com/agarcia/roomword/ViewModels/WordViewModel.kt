package com.agarcia.roomword.ViewModels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.agarcia.roomword.Repository.WordRepository
import com.agarcia.roomword.RoomDatabase.Word
import com.agarcia.roomword.RoomDatabase.WordRoomDatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class WordViewModel(application: Application): AndroidViewModel(application){

    private val wordRepository: WordRepository
    val allWords: LiveData<List<Word>>

    init{
        val wordsDao = WordRoomDatabase.getDatabase(application, viewModelScope).wordDao()
        wordRepository = WordRepository(wordsDao)

        allWords = wordRepository.allWords
    }

    fun insert(word:Word) = viewModelScope.launch(Dispatchers.IO){
        wordRepository.insert(word)
    }

}