package com.example.myapplication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.myapplication.databinding.FragmentMvvmBinding
import com.example.myapplication.mvvmcode.CountViewModel
import com.example.myapplication.mvvmcode.CountViewModelFactory

/**
 * A simple [Fragment] subclass.
 * Use the [MvvmFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class MvvmFragment : Fragment() {
    private lateinit var textView: TextView
    private lateinit var button: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<FragmentMvvmBinding>(inflater, R.layout.fragment_mvvm, container, false)

        textView = binding.textView
        button = binding.button

//        // 1
//        var count = 0
//        textView.text = count.toString()

//        // 2
//        var countViewModel = ViewModelProvider(this).get(CountViewModel::class.java)
//        textView.text = countViewModel.count.toString()

//        // 3 - countdown without livedata
//        var countViewModel = ViewModelProvider(this).get(CountViewModel::class.java)
//        textView.text = countViewModel.seconds.toString()

//        // 4
//        var countViewModel = ViewModelProvider(this).get(CountViewModel::class.java)
//        countViewModel.seconds().observe(viewLifecycleOwner, Observer {seconds: Int ->
//            textView.text = seconds.toString()
//        })


        // 5
        var countViewModelFactory = CountViewModelFactory("Mehdi")
        var countViewModel = ViewModelProvider(this, countViewModelFactory).get(CountViewModel::class.java)
        binding.lifecycleOwner = this
        binding.countViewModel = countViewModel



        button.setOnClickListener {
//            // 1
//            count++; textView.text = count.toString()

//            // 2
//            countViewModel.add()
//            textView.text = countViewModel.count.toString()  // 2

            // 3
            countViewModel.startTimer()



        }


        return binding.root
    }
}