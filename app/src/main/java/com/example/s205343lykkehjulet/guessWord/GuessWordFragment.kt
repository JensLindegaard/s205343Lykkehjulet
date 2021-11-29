package com.example.s205343lykkehjulet.guessWord

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.example.s205343lykkehjulet.R
import com.example.s205343lykkehjulet.databinding.FragmentGuessWordBinding

class GuessWordFragment : Fragment(), View.OnClickListener {
    private var _binding: FragmentGuessWordBinding? = null
    private val binding get() = _binding!!
    var navController: NavController? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentGuessWordBinding.inflate(inflater, container, false)
        val root: View = binding.root
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)
        view.findViewById<Button>(R.id.btnGuess).setOnClickListener(this)
        binding.btnGuess.setOnClickListener {
        //            viewModel.run()
        }
        view.findViewById<Button>(R.id.Til_Tabt_skærm)
        binding.TilTabtSkRm.setOnClickListener {
            findNavController().navigate(R.id.action_guessWordFragment_to_gameLost)
        }

        view.findViewById<Button>(R.id.Til_Vundet_Skærm)
        binding.TilTabtSkRm.setOnClickListener {
            findNavController().navigate(R.id.action_guessWordFragment_to_gameWon)
        }
    }

    override fun onClick(p0: View?) {

    }
}