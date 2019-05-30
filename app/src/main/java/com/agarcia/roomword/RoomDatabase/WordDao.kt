package com.agarcia.roomword.RoomDatabase

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.agarcia.roomword.Utilities.Constants

@Dao
interface WordDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(word:Word)

    @Query("SELECT * from ${Constants.WordTableName} ORDER BY word ASC")
    fun getAllWords(): LiveData<List<Word>>

    @Query("DELETE from ${Constants.WordTableName}")
    fun deleteAll()
}