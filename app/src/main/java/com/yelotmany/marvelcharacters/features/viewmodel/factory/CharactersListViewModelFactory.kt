package com.yelotmany.marvelcharacters.features.viewmodel.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.yelotmany.marvelcharacters.features.model.repository.datasource.remote.RemoteDataSource
import com.yelotmany.marvelcharacters.features.model.repository.impl.CharactersRepositoryImpl
import com.yelotmany.marvelcharacters.features.viewmodel.CharactersListViewModel
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class CharactersListViewModelFactory @Inject constructor(
    private val remoteDataSource: RemoteDataSource): ViewModelProvider.Factory{

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        @Suppress("UNCHECKED_CAST")
        return CharactersListViewModel(charactersRepository = CharactersRepositoryImpl(remoteDataSource = remoteDataSource)) as T
    }

}
