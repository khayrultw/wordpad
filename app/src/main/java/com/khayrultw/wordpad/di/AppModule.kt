package com.khayrultw.wordpad.di

import android.app.Application
import androidx.room.Room
import com.khayrultw.wordpad.data.apis.WordDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideWordDatabase(app: Application): WordDatabase {
        return Room.databaseBuilder(
            app,
            WordDatabase::class.java,
            WordDatabase.DATABASE_NAME
        ).build()
    }
}