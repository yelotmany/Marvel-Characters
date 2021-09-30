package com.yelotmany.marvelcharacters.features.model.entities

data class MarvelCharacter constructor(
    var id: String = "",
    var imageURL: String = "",
    var name: String = "",
    var author: String = "",
    var description: String = ""
)
