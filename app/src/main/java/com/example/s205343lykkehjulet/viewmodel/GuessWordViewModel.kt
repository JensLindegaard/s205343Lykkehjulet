package com.example.s205343lykkehjulet.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.s205343lykkehjulet.data.Datasource
import java.lang.StringBuilder
import kotlin.math.absoluteValue

// Brugt Codelabs Units til opbygning og inspiration til funktioner

class GuessWordViewModel : ViewModel() {

    private val _words = MutableLiveData<String>()
    val words: LiveData<String> = _words
    var currentlifes = 5
    private var letterInput = ""
    var currentPoints = 0
    var updatedPoints = 0

    private val getPossibleWords = Datasource().wordsPosible

    fun makeWords() {
        val wordsMake = getPossibleWords.random()
        _words.value = wordsMake.words.random()
    }

// Taget inspiration fra, https://github.com/usmaanz/Hangman/blob/master/app/src/main/java/com/usmaan/hangman/GameManager.kt,
// til at lave underScores.

    fun underScores(): String {
        val letters = StringBuilder()
        words.value?.forEach { char ->
            if (char == ' ') {
                letters.append(' ')
            } else {
                if (letterInput.contains(char, ignoreCase = true)) {
                    letters.append(char)
                } else {
                    letters.append('_')
                }
            }
        }
        return letters.toString()
    }

    fun isLetterInWord(letter: String) {
        var inputOfLetters = letter
        var underscoredWord = words.value
        var checkifLetterinWord =
            underscoredWord?.contains(inputOfLetters.toCharArray().first(), ignoreCase = true)
        letterInput += inputOfLetters

        val timesLetterinWord = underscoredWord?.count {
            letter.lowercase().contains(it.lowercase())
        }
        if (checkifLetterinWord!!) {

            currentPoints += timesLetterinWord!! * updatedPoints
        } else{
            currentlifes -= 1
        }
    }

    fun spinWheel(){
        updatedPoints = listOf<Int>(0, 100, 200, 300, 400).random()
    }

    var listOfGueesedLetters = mutableListOf<Char>()

    fun guessSameLetter(letter: String): Boolean{
        var same = false
        if (listOfGueesedLetters.contains(letter.lowercase().single())) {
            same = true
        }
        listOfGueesedLetters.add(letter.lowercase().single())
        return same
    }


    fun checkifGameWon(): Boolean {
        var lettersinword = words.value?.lowercase()?.toList()
        if (listOfGueesedLetters.containsAll(lettersinword!!)) {
            return true
        } else {
            return false
        }
    }

    fun checkifGameLost(): Boolean {
        if (currentlifes <= 0) {
            return true
        } else {
            return false
        }
    }
}
