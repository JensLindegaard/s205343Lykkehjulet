package com.example.s205343lykkehjulet

sealed class gameState{
    class playingGame(val usedLetters: String, val underScore:String): gameState()
    class lostGame(guessWord: String):gameState()
    class wonGame(guessWord: String): gameState()
}
