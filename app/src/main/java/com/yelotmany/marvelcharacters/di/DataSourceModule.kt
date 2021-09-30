package com.yelotmany.marvelcharacters.di

import com.yelotmany.marvelcharacters.features.model.repository.datasource.CharactersDataSource
import com.yelotmany.marvelcharacters.features.model.repository.datasource.impl.MockDataSource
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DataSourceModule {

    @Singleton
    @Provides
    fun provideMockDataSource(): CharactersDataSource{
        return MockDataSource()
    }
}