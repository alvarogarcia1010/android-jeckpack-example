package com.agarcia.roomword.Repository

import androidx.annotation.WorkerThread
import androidx.lifecycle.LiveData
import com.agarcia.roomword.RoomDatabase.Word
import com.agarcia.roomword.RoomDatabase.WordDao

class WordRepository(private val wordDao: WordDao) {

    val allWords: LiveData<List<Word>> = wordDao.getAllWords()

    @WorkerThread
    suspend fun insert(word: Word) {
        wordDao.insert(word)
    }
}