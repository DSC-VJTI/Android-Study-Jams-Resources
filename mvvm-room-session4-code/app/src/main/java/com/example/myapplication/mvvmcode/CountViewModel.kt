package com.example.myapplication.mvvmcode

import android.os.CountDownTimer
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CountViewModel(private val name: String): ViewModel() {

    init {
        Log.i("CountViewModel", "Initialized $name")
    }

//    // 1
//    var count: Int = 0
//    fun add() = count++

//    // 2
//    private lateinit var timer: CountDownTimer
//    var seconds: Int = 0
//    fun startTimer(){
//        timer = object : CountDownTimer(10000, 1000) {
//            override fun onFinish() {
//                Log.i("CountViewModel", "Timer Stopped")
//                stopTimer()
//            }
//
//            override fun onTick(p0: Long) {
//                val timeLeft = p0/1000  // ms to s
//                seconds = timeLeft.toInt()
//            }
//
//        }.start()
//    }
//
//    fun stopTimer() {
//        timer.cancel()
//    }



    // 3
    private lateinit var timer: CountDownTimer

    private var _seconds = MutableLiveData<Int>()
    fun seconds(): LiveData<Int> = _seconds

    fun startTimer(){
        timer = object : CountDownTimer(10000, 1000) {
            override fun onFinish() {
                Log.i("CountViewModel", "Timer Stopped")
                stopTimer()
            }

            override fun onTick(p0: Long) {
                val timeLeft = p0/1000
                _seconds.value = timeLeft.toInt()
            }

        }.start()
    }

    fun stopTimer() {
        timer.cancel()
    }



    override fun onCleared() {
        super.onCleared()
        Log.i("CountViewModel", "onClearedCalled")
    }
}