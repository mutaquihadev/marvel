package com.mutaquiha.marvel.data.di

import com.mutaquiha.marvel.data.repositories.CharacterRepository
import com.mutaquiha.marvel.data.repositories.CharacterRepositoryImpl
import com.mutaquiha.marvel.data.repositories.ComicsRepository
import com.mutaquiha.marvel.data.repositories.ComicsRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
abstract class RepositoryModule {

    @Singleton
    @Binds
    abstract fun provideCharactersListRepository(
        characterRepositoryImpl: CharacterRepositoryImpl
    ): CharacterRepository

    @Singleton
    @Binds
    abstract fun provideComicsRepository(
        comicsRepositoryImpl: ComicsRepositoryImpl
    ): ComicsRepository
}