package com.example.s205343lykkehjulet.UI

import android.os.Bundle
import android.view.LayoutInflater
import androidx.fragment.app.Fragment
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.s205343lykkehjulet.R
import com.example.s205343lykkehjulet.databinding.FragmentGameLostBinding

// Brugt Codelab til hjælp med denne del koden

class GameLostFragment : Fragment() {
    private var _binding: FragmentGameLostBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentGameLostBinding.inflate(inflater, container, false)
        val root: View = binding.root
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.TabtTilHjem.setOnClickListener {
            findNavController().navigate(R.id.action_gameLost_to_startGameFragment)
        }
    }
}