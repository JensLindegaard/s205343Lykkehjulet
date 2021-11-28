package com.example.s205343lykkehjulet.ui.gameWon

import android.os.Bundle
import android.view.LayoutInflater
import androidx.fragment.app.Fragment
import android.view.View
import android.view.ViewGroup
import com.example.s205343lykkehjulet.R
import com.example.s205343lykkehjulet.databinding.FragmentGameWonBinding

class GameWon : Fragment() {
    private var _binding: FragmentGameWonBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentGameWonBinding.inflate(inflater, container, false)
        val root: View = binding.root
        return root
    }

}