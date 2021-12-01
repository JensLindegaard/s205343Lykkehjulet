package com.example.s205343lykkehjulet.UI

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.example.s205343lykkehjulet.data.Datasource

private val _category = MutableLiveData<String>()
val category: LiveData<String> = _category
private val _words = MutableLiveData<String>()
val words: LiveData<String> = _words
private var ordgaettet = ""



class GuessWordViewModel : ViewModel() {

    private val lifes = 5
    private val point = 0
    private val getPossibleWords = Datasource().muligeOrd

    fun bogstav(letterGuess: String){

    }

    fun spinWheel(){

    }
}





//private val _character = MutableLiveData<MutableList<Char>>()
//val character: LiveData<List<Char>> = Transformations.map(_character) {
//    it.toList()
//}