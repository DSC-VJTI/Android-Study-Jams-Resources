package com.example.myapplication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import com.example.myapplication.databinding.FragmentHomeBinding
import com.example.myapplication.databinding.FragmentOddScreenBinding


/**
 * A simple [Fragment] subclass.
 * Use the [OddScreen.newInstance] factory method to
 * create an instance of this fragment.
 */
class OddScreen : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<FragmentOddScreenBinding>(inflater, R.layout.fragment_odd_screen, container, false)
        val args = OddScreenArgs.fromBundle(requireArguments())
        val textView = binding.oddText
        textView.text = "Odd Number: ${args.number.toString()}"
        // Inflate the layout for this fragment
        return binding.root
    }
}