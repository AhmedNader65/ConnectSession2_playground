package com.example.navigation

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.navigation.databinding.FragmentABinding
import com.example.navigation.databinding.FragmentBBinding

class FragmentB : Fragment() {
    lateinit var viewModel: FragmentViewModel
    lateinit var viewModelB: FragmentBViewModel
    private lateinit var binding: FragmentBBinding
    val args by navArgs<FragmentBArgs>()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        viewModel = ViewModelProvider(requireActivity())[FragmentViewModel::class.java]
        viewModelB = ViewModelProvider(this)[FragmentBViewModel::class.java]
        // Inflate the layout for this fragment
        binding = FragmentBBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.textView.text = args.key
        binding.textView.setOnClickListener {
            startActivity(Intent(requireContext(),SecondActivity::class.java)
                .putExtra("key","Udacity#2"))
        }
        viewModelB.data.observe(requireActivity()) {

        }
    }

}