package com.example.calendarstyles.ui

import android.os.Build
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.CalendarView
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.example.calendarstyles.R
import com.example.calendarstyles.databinding.ActivityMainBinding
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.Calendar
import java.util.Date

class MainActivity: AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var calendar: Calendar
    private lateinit var calendarView: CalendarView
    private lateinit var labelDate: TextView
    private lateinit var buttonChangeStyle: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setupBinding()
        setupCalendar()
        setupButtonStyle()
    }

    private fun setupBinding() {
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
    }

    private fun setupCalendar() {
        calendarView = binding.calendarView
        labelDate = binding.descriptionData
        labelDate.text = Calendar.DATE.toString()
        calendar = Calendar.getInstance()

        calendarView.setOnDateChangeListener { view, year, month, dayOfMonth ->
            val message = "$dayOfMonth/$month/$year"
            Toast.makeText(this@MainActivity, message, Toast.LENGTH_SHORT).show()
            labelDate.text = message
        }
    }

    private fun setupButtonStyle() {
        buttonChangeStyle = binding.buttonSelect
        buttonChangeStyle.setOnClickListener {
            calendarView.dateTextAppearance = com.google.android.material.R.style.TextAppearance_AppCompat_SearchResult_Subtitle
        }
    }

    fun getToday(): String {
        val sdf = SimpleDateFormat("dd 'de' MMMM 'de' yyyy")
        val date = Date()
        return sdf.format(date)
    }

}