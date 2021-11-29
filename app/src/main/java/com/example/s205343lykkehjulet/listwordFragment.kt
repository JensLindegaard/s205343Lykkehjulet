package com.example.s205343lykkehjulet

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.s205343lykkehjulet.adapter.ItemAdapter
import com.example.s205343lykkehjulet.data.Datasource
import com.example.s205343lykkehjulet.databinding.FragmentGuessWordBinding
import com.example.s205343lykkehjulet.databinding.FragmentListwordBinding

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

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)
//
//        val myDataset = Datasource().loadAffirmations()
//
//        val recyclerView = findViewById<RecyclerView>(R.id.recycler_view)
//        recyclerView.adapter = ItemAdapter(this, myDataset)
//
//        recyclerView.setHasFixedSize(true)
    }
}