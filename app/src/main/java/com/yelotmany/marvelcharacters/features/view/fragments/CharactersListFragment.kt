package com.yelotmany.marvelcharacters.features.view.fragments

import android.content.Context
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.view.*
import android.view.inputmethod.InputMethodManager
import android.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.yelotmany.marvelcharacters.MarvelCharactersApplication
import com.yelotmany.marvelcharacters.R
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

        setHasOptionsMenu(true)
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

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        menu.clear()
        inflater.inflate(R.menu.options_menu, menu)

        val search = menu.findItem(R.id.search)
        val searchView = search?.actionView as SearchView
        searchView.isIconifiedByDefault = false
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {

            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                viewDataBinding.viewModel?.filterList(newText ?: "")
                Log.d("Filtro", "$newText")
                return true
            }
        })

        // handle expansion and collapse effect
        search.setOnActionExpandListener(object : MenuItem.OnActionExpandListener {

            override fun onMenuItemActionExpand(item: MenuItem?): Boolean {
                searchView.requestFocus()
                Handler(Looper.getMainLooper()).post {
                    searchView.requestFocus()
                    val imm =
                        activity?.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager?
                    imm?.showSoftInput(searchView.findFocus(), 0)
                }
                return true
            }

            override fun onMenuItemActionCollapse(item: MenuItem?): Boolean {
                searchView.clearFocus()
                return true
            }
        })
    }
}
