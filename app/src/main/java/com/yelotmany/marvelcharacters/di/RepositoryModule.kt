package com.yelotmany.marvelcharacters.di

import com.yelotmany.marvelcharacters.features.main.model.repository.CharactersRepository
import com.yelotmany.marvelcharacters.features.main.model.repository.impl.CharactersRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun provideRepository(repository: CharactersRepositoryImpl): CharactersRepository
}
