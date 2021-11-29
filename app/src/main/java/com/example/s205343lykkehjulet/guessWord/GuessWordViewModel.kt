package com.example.s205343lykkehjulet.guessWord

import android.util.Log
import androidx.lifecycle.ViewModel
import java.util.ArrayList

class GuessWordViewModel : ViewModel() {
    val brugteBogstaver = ArrayList<String>()
    var ordet: String? = null
    private var sidsteBogstavVarKorrekt = false
    private var spilletErVundet = false
    private var spilletErTabt = false
    var antalForkerteBogstaver = 0
    var synligtOrd: String? = null

    private fun opdaterSynligtOrd() {
        synligtOrd = ""
        spilletErVundet = true
        for (n in 0 until ordet!!.length) {
            val bogstav = ordet!!.substring(n, n + 1)
            if (brugteBogstaver.contains(bogstav)) {
                synligtOrd = synligtOrd + bogstav
            } else {
                synligtOrd = "$synligtOrd*"
                spilletErVundet = false
            }
        }
    }

    fun gætBogstav(bogstav: String) {
        if (bogstav.length != 1) return
        println("Der gættes på bogstavet: $bogstav")
        if (brugteBogstaver.contains(bogstav)) return
        if (spilletErVundet || spilletErTabt) return
        brugteBogstaver.add(bogstav)
        if (ordet!!.contains(bogstav)) {
            sidsteBogstavVarKorrekt = true
            println("Bogstavet var korrekt: $bogstav")
        } else {
            // Vi gættede på et bogstav der ikke var i ordet.
            sidsteBogstavVarKorrekt = false
            println("Bogstavet var IKKE korrekt: $bogstav")
            antalForkerteBogstaver = antalForkerteBogstaver + 1
            if (antalForkerteBogstaver > 6) {
                spilletErTabt = true
            }
        }
        opdaterSynligtOrd()
    }
}