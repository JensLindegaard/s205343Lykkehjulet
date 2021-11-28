package com.example.s205343lykkehjulet.ui.startGame

import android.os.Bundle
import android.view.LayoutInflater
import androidx.fragment.app.Fragment
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.s205343lykkehjulet.R
import com.example.s205343lykkehjulet.databinding.FragmentStartGameBinding

class StartGameFragment : Fragment(), View.OnClickListener {
    private lateinit var startGameViewModel: StartGameViewModel
    private var _binding: FragmentStartGameBinding? = null
    private val binding get() = _binding!!
    var navController: NavController? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        startGameViewModel =
            ViewModelProvider(this).get(StartGameViewModel::class.java)
        _binding = FragmentStartGameBinding.inflate(inflater, container, false)
        val root: View = binding.root

        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)
        view.findViewById<Button>(R.id.start_game_button).setOnClickListener(this)
    }

    override fun onClick(p0: View?) {
        when (p0!!.id) {
            R.id.start_game_button -> navController!!.navigate(R.id.action_startGameFragment_to_guessWordFragment)

        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}