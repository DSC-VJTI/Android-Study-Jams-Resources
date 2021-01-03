package com.example.myapplication.mvvmcode

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import java.lang.IllegalArgumentException

class CountViewModelFactory(private val name: String): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(CountViewModel::class.java)){
            return CountViewModel(name) as T
        }
        throw IllegalArgumentException("Unknown ViewModel Class")
    }
}