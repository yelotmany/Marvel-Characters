package com.yelotmany.marvelcharacters.features.model.repository

import com.yelotmany.marvelcharacters.features.model.entities.MarvelCharacter

interface CharactersRepository {

    fun loadMarvelCharactersList(): List<MarvelCharacter>
}