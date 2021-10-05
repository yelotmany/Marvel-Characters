package com.yelotmany.marvelcharacters.features.view.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent


class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        startActivity(Intent(this, CharactersListActivity::class.java))
        finish()
    }
}