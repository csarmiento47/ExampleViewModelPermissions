package com.desafiolatam.viewmodel

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import com.desafiolatam.viewmodel.databinding.FragmentLowerBinding

class LowerFragment : Fragment() {

    val viewModel: MainViewModel by activityViewModels()
    private lateinit var binding: FragmentLowerBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentLowerBinding.inflate(layoutInflater, container, false)

        binding.tvClick.setOnClickListener {
            viewModel.increase()
        }
        return binding.root
    }
}