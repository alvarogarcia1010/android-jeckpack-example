package com.agarcia.roomword.RoomDatabase

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.agarcia.roomword.Utilities.Constants

@Entity(tableName = Constants.WordTableName)
data class Word(@PrimaryKey @ColumnInfo(name ="word") val word:String)