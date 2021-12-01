package com.example.s205343lykkehjulet

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.s205343lykkehjulet.data.Datasource
import java.lang.StringBuilder
import kotlin.random.Random

private val _category = MutableLiveData<String>()
val category: LiveData<String> = _category
private val _words = MutableLiveData<String>()
val words: LiveData<String> = _words
private var ordgaettet = ""



class GuessWordViewModel : ViewModel() {

    private val getPossibleWords = Datasource().wordsPosible

    private val rightGuess = mutableListOf<String>()

    private var noShowWord: String =  ""
    private lateinit var underscores: String
    private lateinit var wordToGuess: String
    private var maxLifes = 5
    private val currentPoint = 0

    fun newGame(){
        noShowWord = ""
        maxLifes = 5
        val randomIndex = Random.nextInt(0,getPossibleWords.size)
        wordToGuess = getPossibleWords[randomIndex].toString()
        underScores(wordToGuess)
    }

    fun underScores(word: String){
        val letters = StringBuilder()
        word.forEach { char ->
            if(char =='/'){
                letters.append('/')
            } else {
                letters.append('_')
            }
        underscores = letters.toString()
        }
    }


    fun bogstav(letterGuess: String){

    }

    fun spinWheel(){

    }
}





//private val _character = MutableLiveData<MutableList<Char>>()
//val character: LiveData<List<Char>> = Transformations.map(_character) {
//    it.toList()
//}