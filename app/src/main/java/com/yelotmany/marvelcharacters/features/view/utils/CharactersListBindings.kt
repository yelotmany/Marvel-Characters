package com.yelotmany.marvelcharacters.features.view

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.yelotmany.marvelcharacters.features.model.entities.MarvelCharacter

@BindingAdapter("application:items")
fun setItems(listView: RecyclerView, items: List<MarvelCharacter>) {
    (listView.adapter as CharactersAdapter).submitList(items)
}