package com.example.s205343lykkehjulet.ui.gameLost

import android.os.Bundle
import android.view.LayoutInflater
import androidx.fragment.app.Fragment
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import com.example.s205343lykkehjulet.R
import com.example.s205343lykkehjulet.databinding.FragmentGameLostBinding

class GameLost : Fragment() {
    private var _binding: FragmentGameLostBinding? = null
    private val binding get() = _binding!!
    var navController: NavController? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentGameLostBinding.inflate(inflater, container, false)
        val root: View = binding.root
        return root
    }
}