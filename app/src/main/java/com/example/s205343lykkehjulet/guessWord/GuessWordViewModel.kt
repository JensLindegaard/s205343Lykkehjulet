package com.example.s205343lykkehjulet.guessWord

import android.util.Log
import androidx.lifecycle.ViewModel

class GuessWordViewModel : ViewModel() {
    var liv = 8

    fun words(){

    }






    fun UsedLives() {
        liv -= 1
    }

//    fun loadWords(): List<>


    fun run() {
        Log.d("test", liv.toString())
    }
}