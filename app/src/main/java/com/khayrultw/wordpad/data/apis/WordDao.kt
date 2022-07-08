package com.khayrultw.wordpad.data.apis

import androidx.room.*
import com.khayrultw.wordpad.data.apis.model.Word

@Dao
interface WordDao {
    @Query("SELECT * FROM word")
    suspend fun getWords(): List<Word>

    @Query("SELECT * FROM word WHERE id = :id")
    suspend fun getWordById(id: Int): Word?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertWord(word: Word)

    @Query("DELETE FROM word WHERE id = :id")
    suspend fun deleteWord(id: Int)
}