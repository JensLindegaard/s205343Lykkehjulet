package com.example.s205343lykkehjulet

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.fragment.NavHostFragment
import com.example.s205343lykkehjulet.databinding.ActivityMainBinding
import com.example.s205343lykkehjulet.databinding.ActivityMainBinding.*

class MainActivity : AppCompatActivity(R.layout.activity_main) {

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            val navHostFragment =
                supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
            val navController = navHostFragment.navController
        }
    }