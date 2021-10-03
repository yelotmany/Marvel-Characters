package com.yelotmany.marvelcharacters.features.model.entities

data class MarvelCharacter constructor(
    var id: Int = -1,
    var imageURL: String? = "",
    var name: String = "",
    var author: String = "",
    var description: String = ""
)
