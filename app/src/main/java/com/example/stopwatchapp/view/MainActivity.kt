package com.example.stopwatchapp.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.stopwatchapp.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportFragmentManager
            .beginTransaction()
            .add(R.id.container, StopwatchFragment())
            .commit()

    }
}