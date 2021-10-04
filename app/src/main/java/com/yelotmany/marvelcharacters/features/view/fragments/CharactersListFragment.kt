package com.yelotmany.marvelcharacters.features.view.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.yelotmany.marvelcharacters.MarvelCharactersApplication
import com.yelotmany.marvelcharacters.databinding.FragmentCharactersListBinding
import com.yelotmany.marvelcharacters.features.model.entities.MarvelCharacter
import com.yelotmany.marvelcharacters.features.view.CharactersAdapter
import com.yelotmany.marvelcharacters.features.view.activities.CharactersListActivity
import com.yelotmany.marvelcharacters.features.view.utils.NavigateToFragmentEvent
import com.yelotmany.marvelcharacters.features.viewmodel.CharactersListViewModel
import javax.inject.Inject

class CharactersListFragment : Fragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private val charactersListViewModel by viewModels<CharactersListViewModel>{
        viewModelFactory
    }

    private lateinit var viewDataBinding: FragmentCharactersListBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        ((activity as CharactersListActivity).applicationContext as MarvelCharactersApplication)
            .appComponent.inject(this)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {

        viewDataBinding = FragmentCharactersListBinding.inflate(inflater, container, false).apply {
            viewModel = charactersListViewModel
        }

        initializeComponents()
        return viewDataBinding.root
    }

    private fun initializeComponents(){

        viewDataBinding.lifecycleOwner = this.viewLifecycleOwner

        if (viewDataBinding.viewModel == null)
            return

        val charactersAdapter = CharactersAdapter(charactersListViewModel)
        viewDataBinding.fragmentCharactersListRecyclerView.adapter = charactersAdapter

        val viewModel = viewDataBinding.viewModel as CharactersListViewModel

        viewModel.loadCharactersList()
        viewModel.openCharacterEvent.observe(this.viewLifecycleOwner, NavigateToFragmentEvent {
            openCharacterDetails(it)
        })
    }

    private fun openCharacterDetails(character: MarvelCharacter?) {
        val action = CharactersListFragmentDirections.actionCharactersListFragmentToCharacterDetailsFragment(character!!)
        findNavController().navigate(action)
    }
}
