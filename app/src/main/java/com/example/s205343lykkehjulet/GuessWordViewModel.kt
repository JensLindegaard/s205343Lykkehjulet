package com.example.s205343lykkehjulet

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.s205343lykkehjulet.data.Datasource
import java.lang.StringBuilder
import kotlin.random.Random


class GuessWordViewModel : ViewModel() {

    private val _category = MutableLiveData<String>()
    val category: LiveData<String> = _category
    private val _words = MutableLiveData<String>()
    val words: LiveData<String> = _words

    private var lettersGuessed: String = ""
    private lateinit var underscores: String
    private lateinit var wordToGuess: String
    private var lifes = 5
    private var gameoverLifes = 0


    private val getPossibleWords = Datasource().wordsPosible

    fun makeWords() {
        var wordsMake = getPossibleWords.random()
        _words.value = wordsMake.words.random()
    }

    fun underScores(): String {
        val letters = StringBuilder()
        words.value?.forEach { char ->
            if (char == ' ') {
                letters.append(' ')
            } else {
                letters.append('_')
            }
            underscores = letters.toString()
        }
        return letters.toString()
    }

    fun isLetterInWord(letter: String) {
        var inputOfLetters = letter
        var underscoredWord = words.value
        var checkifLetterinWord = underscoredWord?.contains(inputOfLetters.toCharArray().first(), ignoreCase = true)

        val timesLetterinWord = underscoredWord?.count{letter.contains(it)}
        if (checkifLetterinWord!!){
            var currentPoints = timesLetterinWord!! * 10
        }
    }


}

//    private val rightGuess = mutableListOf<String>()
//
//
//
//    fun Game() {
//        lettersGuessed = ""
//        lifes = 5
//        val randomIndex = Random.nextInt(0, getPossibleWords.size)
//        wordToGuess = getPossibleWords[randomIndex].toString()
//        underScores(wordToGuess)
//    }
//

//
//    fun playGame(letters: Char): gameState {
//        if (lettersGuessed.contains(letters)) {
//            return gameState.playingGame(lettersGuessed, underscores)
//        }
//        lettersGuessed += letters
//        val indexes = mutableListOf<Int>()
//
//        wordToGuess.forEachIndexed { index, c ->
//            if (c.equals(letters, true)) {
//                indexes.add(index)
//            }
//        }
//
//        var allUnderscores = "" + underscores
//        indexes.forEach { index ->
//            val stringbuilder = StringBuilder(allUnderscores).also { it.setCharAt(index, letters) }
//            allUnderscores = stringbuilder.toString()
//        }
//
//        if (indexes.isEmpty()) {
//            lifes--
//        }
//
//        underscores = allUnderscores
//        return getgameState()
//    }
//
//    private fun getgameState(): gameState {
//        if (underscores.equals(wordToGuess, true)) {
//            return gameState.wonGame(wordToGuess)
//        }
//
//        if (currentPoints == gameoverLifes) {
//            return gameState.lostGame(wordToGuess)
//        }
//
//        return gameState.playingGame(lettersGuessed, underscores)
//    }
//
//    fun spinWheel() {
//
