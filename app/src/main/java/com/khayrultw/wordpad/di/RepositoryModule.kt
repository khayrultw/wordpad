package com.khayrultw.wordpad.di

import com.khayrultw.wordpad.data.apis.WordDatabase
import com.khayrultw.wordpad.data.repository.WordRepository
import com.khayrultw.wordpad.data.repository.WordRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {
    @Provides
    @Singleton
    fun provideWordRepository(db: WordDatabase): WordRepository {
        return WordRepositoryImpl(db.wordDao)
    }
}