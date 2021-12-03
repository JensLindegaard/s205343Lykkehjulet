package com.example.s205343lykkehjulet.UI

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.s205343lykkehjulet.R
import com.example.s205343lykkehjulet.adapter.WordAdapter
import com.example.s205343lykkehjulet.viewmodel.GuessWordViewModel
import com.example.s205343lykkehjulet.databinding.FragmentGuessWordBinding

// Brugt Codelab til hjælp med denne del koden

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

        binding.rvlettersGuessed.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        binding.rvlettersGuessed.adapter =
            WordAdapter(requireContext(), guesswordviewmodel.listOfGueesedLetters)


        guesswordviewmodel.makeWords()
        binding.apply {
            wordwhatneedstobeguessed.text = guesswordviewmodel.underScores()
        }

        binding.btGuessWord.setOnClickListener {
            if (!guesswordviewmodel.guessSameLetter(letter = binding.Guessword.text.toString())) {
                guesswordviewmodel.isLetterInWord(letter = binding.Guessword.text.toString())
                binding.wordwhatneedstobeguessed.text = guesswordviewmodel.underScores()
                updateView()
            }
        }

        binding.SpinWheel.setOnClickListener {
            guesswordviewmodel.spinWheel()
            updateView()
        }
        binding.currentLifes
    }

    fun updateView() {
        binding.apply {
            currentLifes.text = guesswordviewmodel.currentlifes.toString()
            currentPoints.text = guesswordviewmodel.currentPoints.toString()
            wordwhatneedstobeguessed
            PointsofSpinWhell.text = guesswordviewmodel.updatedPoints.toString()
            binding.rvlettersGuessed.adapter =
                WordAdapter(requireContext(), guesswordviewmodel.listOfGueesedLetters)

        }

        if (guesswordviewmodel.checkifGameWon()) {
            findNavController().navigate(R.id.action_guessWordFragment_to_gameWon)
        }

        if (guesswordviewmodel.checkifGameLost()) {
            findNavController().navigate(R.id.action_guessWordFragment_to_gameLost)
        }
    }
}

