package com.example.stopwatchapp.model

import kotlinx.coroutines.flow.StateFlow

interface IStopwatch {

    val ticker: StateFlow<String>

    fun start()
    fun pause()
    fun stop()
}