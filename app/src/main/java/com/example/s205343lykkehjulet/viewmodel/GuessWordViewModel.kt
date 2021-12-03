package com.example.s205343lykkehjulet.viewmodel

import android.util.Log
import android.widget.Button
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.s205343lykkehjulet.data.Datasource
import com.example.s205343lykkehjulet.databinding.FragmentGameWonBinding
import java.lang.StringBuilder


class GuessWordViewModel : ViewModel() {

    private val _category = MutableLiveData<String>()
    val category: LiveData<String> = _category
    private val _words = MutableLiveData<String>()
    val words: LiveData<String> = _words
    var currentlifes = 5
    private var lettersGuessed: String = ""
    private lateinit var underscores: String
    private var letterInput = ""
    var currentPoints = 0

    private val getPossibleWords = Datasource().wordsPosible

    fun makeWords() {
        val wordsMake = getPossibleWords.random()
        _words.value = wordsMake.words.random()
    }

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
            underscores = letters.toString()
        }
        return letters.toString()
    }

    var updatePoints = 0

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

            currentPoints += timesLetterinWord!! * updatePoints
        } else{
            currentlifes -= 1
        }
    }

    fun spinWheel(){
        updatePoints = listOf<Int>(0, 100, 200, 300, 400).random()
    }

    var listOfGueesedLetters = mutableListOf<Char>()

    fun guessSameLetter(letter: String): Boolean{
        var same = false
        if (listOfGueesedLetters.contains(letter.lowercase().single())){
            same = true
        }
        listOfGueesedLetters.add(letter.lowercase().single())
        return same
    }


    fun checkifGameWon(): Boolean{
        var lettersinword = words.value?.lowercase()?.toList()
        if (listOfGueesedLetters.containsAll(lettersinword!!)){
            return true
        } else {
            return false
        }
    }

    fun checkifGameLost(): Boolean{
        if (currentlifes <= 0){
            return true
        } else {
            return false
        }
    }


}
