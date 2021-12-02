package com.example.s205343lykkehjulet.UI

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.s205343lykkehjulet.GuessWordViewModel
import com.example.s205343lykkehjulet.databinding.FragmentGuessWordBinding

//import com.example.s205343lykkehjulet.UI.GuessWordViewModel

class GuessWordFragment : Fragment() {

    private var _binding: FragmentGuessWordBinding? = null
    private val binding get() = _binding!!
    private val guesswordviewmodel: GuessWordViewModel by viewModels()

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
        guesswordviewmodel.makeWords()
        binding.apply {
            wordwhatneedstobeguessed.text = guesswordviewmodel.underScores()
        }

        binding.Guessword.setOnClickListener {
            guesswordviewmodel.isLetterInWord(letter = binding.Guessword.text.toString())
            binding.wordwhatneedstobeguessed.text = guesswordviewmodel.underScores()
        }

    }


}

