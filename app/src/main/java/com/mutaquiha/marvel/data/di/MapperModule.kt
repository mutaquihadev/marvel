package com.mutaquiha.marvel.data.di

import com.mutaquiha.marvel.data.mapper.CharactersMapper
import com.mutaquiha.marvel.data.mapper.ComicsMapper
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object MapperModule {
    @Singleton
    @Provides
    fun providesComicsMapper(): ComicsMapper {
        return ComicsMapper()
    }

    @Singleton
    @Provides
    fun providesCharactersMapper(): CharactersMapper {
        return CharactersMapper()
    }
}