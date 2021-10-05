package com.yelotmany.marvelcharacters

import android.app.Application
import com.yelotmany.marvelcharacters.di.DaggerApplicationComponent

class MarvelCharactersApplication: Application() {

    val appComponent = DaggerApplicationComponent.create()
}