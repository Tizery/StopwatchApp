package com.example.stopwatchapp.viewmodel

import androidx.lifecycle.ViewModel
import com.example.stopwatchapp.model.IStopwatch
import kotlinx.coroutines.flow.StateFlow

class StopwatchViewModel(
    private val stopwatch: IStopwatch
) : ViewModel() {

    val ticker: StateFlow<String> = stopwatch.ticker

    fun onStartClicked() {
        stopwatch.start()
    }

    fun onPauseClicked() {
        stopwatch.pause()
    }

    fun onStopClicked() {
        stopwatch.stop()
    }
}