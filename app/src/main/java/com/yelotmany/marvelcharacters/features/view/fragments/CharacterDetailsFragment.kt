package com.yelotmany.marvelcharacters.features.view.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.yelotmany.marvelcharacters.MarvelCharactersApplication
import com.yelotmany.marvelcharacters.databinding.FragmentCharacterDetailsBinding
import com.yelotmany.marvelcharacters.features.model.entities.MarvelCharacter
import com.yelotmany.marvelcharacters.features.view.activities.CharactersListActivity


class CharacterDetailsFragment : Fragment() {

    private lateinit var viewDataBinding: FragmentCharacterDetailsBinding

    private var characterParam: MarvelCharacter? = null

    private val args: CharacterDetailsFragmentArgs by navArgs()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        ((activity as CharactersListActivity).applicationContext as MarvelCharactersApplication)
            .appComponent.inject(this)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {

        viewDataBinding = FragmentCharacterDetailsBinding.inflate(inflater, container, false).apply {
            character = characterParam
        }
        characterParam = args.character

        return viewDataBinding.root
    }
}