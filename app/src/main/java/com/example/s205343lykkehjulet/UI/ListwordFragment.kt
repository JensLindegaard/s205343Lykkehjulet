package com.example.s205343lykkehjulet.UI

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.s205343lykkehjulet.databinding.FragmentListwordBinding

// Brugt Codelab til hjælp med denne del koden

class listwordFragment : Fragment() {
    private var _binding: FragmentListwordBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentListwordBinding.inflate(inflater, container, false)
        return binding.root
    }
}