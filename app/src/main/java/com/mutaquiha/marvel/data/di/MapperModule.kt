package com.mutaquiha.marvel.data.di

import com.mutaquiha.marvel.data.mapper.CharacterMapper
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
    fun providesCharacterMapper(): CharacterMapper {
        return CharacterMapper()
    }
}