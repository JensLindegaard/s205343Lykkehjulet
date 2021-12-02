package com.example.s205343lykkehjulet

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.navigation.fragment.NavHostFragment
import com.example.s205343lykkehjulet.databinding.ActivityMainBinding
import com.example.s205343lykkehjulet.databinding.ActivityMainBinding.*
import com.example.s205343lykkehjulet.databinding.FragmentGuessWordBinding

class MainActivity : AppCompatActivity(R.layout.activity_main) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        val navController = navHostFragment.navController
    }
}