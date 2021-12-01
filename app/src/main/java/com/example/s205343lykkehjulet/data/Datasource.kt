package com.example.s205343lykkehjulet.data

import android.provider.UserDictionary
import com.example.s205343lykkehjulet.R
import com.example.s205343lykkehjulet.model.possibleWords

class Datasource {

    val muligeOrd = listOf<possibleWords>(
        possibleWords("Biler",
            listOf(
                "BMW",
                "Mercedes",
                "Toyota",
                "Volvo")),

        possibleWords("Mad",
            listOf(
                "Burger",
                "Kylling i karry"
            ))
    )
}