package com.example.workliteapp

import android.graphics.Color
import android.graphics.Paint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.CalendarView
import android.widget.GridLayout
import android.widget.TextView
import androidx.core.content.ContextCompat
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.*

class CalendarActivity : AppCompatActivity() {



    private lateinit var selectedDateTextView: TextView
    private lateinit var calendarView: CalendarView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calendar)

        selectedDateTextView = findViewById(R.id.idTVDate)
        calendarView = findViewById(R.id.calendarView)

        // Set the initial selected date to today's date
        val currentDate = Calendar.getInstance().time
        selectedDateTextView.text = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(currentDate)

        // Set initial selected date on the calendar
        calendarView.date = currentDate.time

        // Set listener for calendar view
        // Set listener for calendar view
        calendarView.setOnDateChangeListener { _, year, month, dayOfMonth ->
            val selectedDate = Calendar.getInstance()
            selectedDate.set(year, month, dayOfMonth)
            val formattedDate = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(selectedDate.time)
            selectedDateTextView.text = formattedDate

            // Highlight selected date on the calendar even if it's in the next/previous month
            calendarView.date = selectedDate.timeInMillis

            // Highlight the same date in the next month
            val nextMonthDate = Calendar.getInstance()
            nextMonthDate.timeInMillis = selectedDate.timeInMillis
            nextMonthDate.add(Calendar.MONTH, 1) // Move to next month
            calendarView.setDate(nextMonthDate.timeInMillis, true, true)
        }



    }
}