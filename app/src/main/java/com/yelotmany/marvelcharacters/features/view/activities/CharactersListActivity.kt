package com.yelotmany.marvelcharacters.features.view.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.add
import androidx.fragment.app.commit
import com.yelotmany.marvelcharacters.MarvelCharactersApplication
import com.yelotmany.marvelcharacters.R
import com.yelotmany.marvelcharacters.features.view.fragments.CharactersListFragment

class CharactersListActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        (applicationContext as MarvelCharactersApplication).appComponent.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_characters_list)

        showFirstFragment()
    }

    private fun showFirstFragment() {
        supportFragmentManager.commit {
            setReorderingAllowed(true)
            add<CharactersListFragment>(R.id.activity_characters_list_fragment)
        }
    }

}