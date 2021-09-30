package com.yelotmany.marvelcharacters.features.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import com.yelotmany.marvelcharacters.R
import com.yelotmany.marvelcharacters.databinding.MainListCharacterCardBinding
import com.yelotmany.marvelcharacters.features.model.entities.MarvelCharacter
import com.yelotmany.marvelcharacters.features.viewmodel.CharactersListViewModel

class CharactersAdapter(private val viewModel: CharactersListViewModel) :
    ListAdapter<MarvelCharacter, CharactersAdapter.ViewHolder>(CharacterDiffCallback){

    class ViewHolder private constructor(val binding: MainListCharacterCardBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(viewModel: CharactersListViewModel, character: MarvelCharacter){

            binding.viewModel = viewModel
            binding.character = character

            /*if (character.imageURL != null)
                Picasso.get().load(character.imageURL).into(binding.cardCharacterAvatarImageView)
            else*/
            binding.cardCharacterAvatarImageView.setImageResource(R.drawable.ic_avatar)
            binding.executePendingBindings()

        }

        companion object {
            fun from(parent: ViewGroup): ViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = MainListCharacterCardBinding.inflate(layoutInflater, parent, false)

                return ViewHolder(binding)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.from(parent)
    }

    override fun onBindViewHolder(holderCharacter: ViewHolder, position: Int) {

        val character = getItem(position)
        holderCharacter.bind(viewModel, character)
    }
}

object CharacterDiffCallback : DiffUtil.ItemCallback<MarvelCharacter>() {
    override fun areItemsTheSame(oldItem: MarvelCharacter, newItem: MarvelCharacter): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: MarvelCharacter, newItem: MarvelCharacter): Boolean {
        return oldItem.id == newItem.id
    }
}