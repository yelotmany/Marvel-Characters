package com.yelotmany.marvelcharacters.features.model.repository.datasource.impl

import androidx.lifecycle.MutableLiveData
import com.yelotmany.marvelcharacters.features.model.entities.MarvelCharacter
import com.yelotmany.marvelcharacters.features.model.repository.datasource.CharactersDataSource

class MockDataSource: CharactersDataSource {

    private var charactersList: MutableLiveData<List<MarvelCharacter>> = MutableLiveData()

    override fun loadMockCharactersList(): MutableLiveData<List<MarvelCharacter>> {
        charactersList.value = listOf(
            MarvelCharacter(id = "1",name = "Hero1",author = "Youssef El Otmany",description = "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book"),
            MarvelCharacter(id = "2",name = "Hero2",author = "Youssef El Otmany",description = "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book"),
            MarvelCharacter(id = "3",name = "Hero3",author = "Youssef El Otmany",description = "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book"),
            MarvelCharacter(id = "4",name = "Hero4",author = "Youssef El Otmany",description = "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book"),
            MarvelCharacter(id = "5",name = "Hero5",author = "Youssef El Otmany",description = "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book")
        )

        return charactersList
    }

}