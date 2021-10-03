package com.yelotmany.marvelcharacters.features.view

import android.view.View
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.databinding.BindingAdapter
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import com.yelotmany.marvelcharacters.R
import com.yelotmany.marvelcharacters.features.model.entities.MarvelCharacter

@BindingAdapter("application:items")
fun setItems(listView: RecyclerView, items: List<MarvelCharacter>?) {

    (listView.adapter as CharactersAdapter).submitList(items ?: ArrayList<MarvelCharacter>())
}

@BindingAdapter("application:description")
fun setDescription(textView: TextView, description: String) {

    textView.text = if (description == "") textView.resources.getString(R.string.without_description) else description
}

@BindingAdapter("application:avatar")
fun setAvatar(imageView: ImageView, imageURL: String?) {

    if (imageURL != null)
        Picasso.get().load(imageURL).into(imageView)
    else
        imageView.setImageResource(R.drawable.ic_avatar)
}

@BindingAdapter("application:progressBarVisibility")
fun setProgressBarVisibility(progressBar: ProgressBar, visibility: MutableLiveData<Boolean>){

    val changeObserver = Observer<Boolean> { newValue ->
       progressBar.visibility = if (newValue) View.VISIBLE else View.INVISIBLE
    }
    visibility.observeForever(changeObserver)
}
