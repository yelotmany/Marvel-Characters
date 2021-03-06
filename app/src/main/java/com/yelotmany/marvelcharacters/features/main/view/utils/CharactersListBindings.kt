package com.yelotmany.marvelcharacters.features.main.view

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
import com.yelotmany.marvelcharacters.features.main.model.repository.datasource.remote.rest.utils.RequestResult

@BindingAdapter("items")
fun setItems(listView: RecyclerView, requestResult: RequestResult?) {

    if (requestResult == null || requestResult !is RequestResult.Success)
        return

    (listView.adapter as CharactersAdapter).submitList(requestResult.result)
}

@BindingAdapter("description")
fun setDescription(textView: TextView, description: String) {

    textView.text = if (description == "") textView.resources.getString(R.string.without_description) else description
}

@BindingAdapter("avatar")
fun setAvatar(imageView: ImageView, imageURL: String?) {

    if (imageURL != null)
        Picasso.get().load(imageURL).into(imageView)
    else
        imageView.setImageResource(R.drawable.ic_avatar)
}

@BindingAdapter("progressBarVisibility", requireAll = true)
fun setProgressBarVisibility(progressBar: ProgressBar, requestResult: MutableLiveData<RequestResult>){

    val changeObserver = Observer<RequestResult> { response ->
       progressBar.visibility = if (response is RequestResult.Loading) View.VISIBLE else View.INVISIBLE
    }
    requestResult.observeForever(changeObserver)
}

@BindingAdapter("listScreenVisibility")
fun setListScreenVisibility(recyclerView: RecyclerView, requestResult: MutableLiveData<RequestResult>){

    val changeObserver = Observer<RequestResult> { response ->
        recyclerView.visibility = if (response is RequestResult.Success) View.VISIBLE else View.INVISIBLE
    }
    requestResult.observeForever(changeObserver)
}

@BindingAdapter("setScreenErrorVisibility")
fun setScreenErrorVisibility(view: View, requestResult: MutableLiveData<RequestResult>){

    val changeObserver = Observer<RequestResult> { response ->
        view.visibility = if (response is RequestResult.Error) View.VISIBLE else View.INVISIBLE
    }
    requestResult.observeForever(changeObserver)
}
