package com.yelotmany.marvelcharacters.di

import com.yelotmany.marvelcharacters.features.view.activities.CharactersListActivity
import com.yelotmany.marvelcharacters.features.view.fragments.CharactersListFragment
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        ViewModelModule::class,
        RepositoryModule::class,
        DataSourceModule::class,
        ApiModule::class
    ])

interface ApplicationComponent {

    fun inject(charactersListActivity: CharactersListActivity)

    fun inject(charactersListFragment: CharactersListFragment)
}
