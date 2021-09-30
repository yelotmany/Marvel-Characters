package com.yelotmany.marvelcharacters.features.viewmodel.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.yelotmany.marvelcharacters.features.model.repository.datasource.CharactersDataSource
import com.yelotmany.marvelcharacters.features.model.repository.impl.CharactersRepositoryImpl
import com.yelotmany.marvelcharacters.features.viewmodel.CharactersListViewModel
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class CharactersListViewModelFactory @Inject constructor(private val dataSource: CharactersDataSource): ViewModelProvider.Factory{

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        @Suppress("UNCHECKED_CAST")
        return CharactersListViewModel(charactersRepository = CharactersRepositoryImpl(dataSource = dataSource)) as T
    }

}