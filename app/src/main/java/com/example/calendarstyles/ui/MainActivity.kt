package com.example.calendarstyles.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.calendarstyles.R
import com.example.calendarstyles.databinding.ActivityMainBinding

class MainActivity: AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setupBinding()
        setupCalendar()
    }

    private fun setupBinding() {
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
    }

    private fun setupCalendar() {
        binding.calendarView
//        binding.constraint.setBackgroundColor()
    }
}