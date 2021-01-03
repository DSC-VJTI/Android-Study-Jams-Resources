package com.example.myapplication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.example.myapplication.databinding.FragmentEvenScreenBinding
import com.example.myapplication.databinding.FragmentHomeBinding


/**
 * A simple [Fragment] subclass.
 * Use the [EvenScreen.newInstance] factory method to
 * create an instance of this fragment.
 */
class EvenScreen : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<FragmentEvenScreenBinding>(inflater, R.layout.fragment_even_screen, container, false)
        val args = EvenScreenArgs.fromBundle(requireArguments())
        val textView = binding.evenText
        textView.text = "Even Number: ${args.number.toString()}"
        return binding.root
    }
}