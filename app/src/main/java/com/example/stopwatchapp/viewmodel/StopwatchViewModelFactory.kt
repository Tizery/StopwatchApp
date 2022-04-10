package com.example.stopwatchapp.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.stopwatchapp.model.IStopwatch

class StopwatchViewModelFactory(
    private val stopwatchBuilder: () -> IStopwatch
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return modelClass
            .getConstructor(IStopwatch::class.java)
            .newInstance(stopwatchBuilder())
    }
}