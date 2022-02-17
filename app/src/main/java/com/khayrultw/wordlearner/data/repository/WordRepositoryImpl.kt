package com.khayrultw.wordlearner.data.repository

import com.khayrultw.wordlearner.data.apis.WordDao
import com.khayrultw.wordlearner.data.apis.model.Word

class WordRepositoryImpl(
    private val dao: WordDao
): WordRepository {
    override suspend fun getWords(): List<Word> {
        return dao.getWords()
    }

    override suspend fun getWordById(id: Int): Word? {
        return dao.getWordById(id)
    }

    override suspend fun insertWord(word: Word) {
        dao.insertWord(word)
    }

    override suspend fun deleteWord(word: Word) {
        dao.deleteWord(word)
    }
}