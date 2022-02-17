package com.khayrultw.wordlearner.di

import com.khayrultw.wordlearner.data.apis.WordDatabase
import com.khayrultw.wordlearner.data.repository.WordRepository
import com.khayrultw.wordlearner.data.repository.WordRepositoryImpl
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