package com.khayrultw.wordpad.data.apis

import androidx.room.Database
import androidx.room.RoomDatabase
import com.khayrultw.wordpad.data.apis.model.Word

@Database(
    entities = [Word::class],
    version = 1
)
abstract class WordDatabase : RoomDatabase() {
    abstract val wordDao: WordDao

    companion object {
        const val DATABASE_NAME = "words_database"
    }
}