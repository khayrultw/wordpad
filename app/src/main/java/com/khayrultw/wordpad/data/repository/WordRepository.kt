package com.khayrultw.wordpad.data.repository

import com.khayrultw.wordpad.data.apis.model.Word

interface WordRepository {
    suspend fun getWords(): List<Word>

    suspend fun getWordById(id: Int): Word?

    suspend fun insertWord(word: Word)

    suspend fun deleteWord(word: Word)
}