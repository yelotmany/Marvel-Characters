package com.yelotmany.marvelcharacters.di

import com.yelotmany.marvelcharacters.features.model.repository.CharactersRepository
import com.yelotmany.marvelcharacters.features.model.repository.datasource.remote.RemoteDataSource
import com.yelotmany.marvelcharacters.features.model.repository.impl.CharactersRepositoryImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoryModule {

    @Singleton
    @Provides
    fun provideRepository(dataSource: RemoteDataSource): CharactersRepository {
        return CharactersRepositoryImpl(remoteDataSource = dataSource)
    }
}
