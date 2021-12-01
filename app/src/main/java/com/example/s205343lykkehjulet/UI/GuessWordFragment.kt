package com.example.s205343lykkehjulet.UI

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.viewModels
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.example.s205343lykkehjulet.GuessWordViewModel
import com.example.s205343lykkehjulet.R
import com.example.s205343lykkehjulet.databinding.FragmentGuessWordBinding

//import com.example.s205343lykkehjulet.UI.GuessWordViewModel

class GuessWordFragment : Fragment() {
    private var _binding: FragmentGuessWordBinding? = null
    private val binding get() = _binding!!
    private val viewModel: GuessWordViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentGuessWordBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        view.findViewById<Button>(R.id.btnGuess).setOnClickListener(this)
//        binding.btnGuess.setOnClickListener {
        //viewModel.run()
    }
}

