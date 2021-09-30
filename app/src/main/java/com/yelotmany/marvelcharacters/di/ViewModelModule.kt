package com.yelotmany.marvelcharacters.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.yelotmany.marvelcharacters.features.viewmodel.CharactersListViewModel
import com.yelotmany.marvelcharacters.features.viewmodel.factory.CharactersListViewModelFactory
import dagger.Binds
import dagger.Module

@Module
abstract class ViewModelModule {

    @Binds
    abstract fun bindViewModel(viewModel: CharactersListViewModel): ViewModel

    @Binds
    abstract fun bindViewModelFactory(factory: CharactersListViewModelFactory):
            ViewModelProvider.Factory
}