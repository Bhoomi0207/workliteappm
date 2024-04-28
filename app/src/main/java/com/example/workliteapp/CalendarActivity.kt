package com.example.workliteapp

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.CalendarView
import android.widget.GridLayout
import android.widget.TextView
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.*

class CalendarActivity : AppCompatActivity() {
    private lateinit var calendarView: CalendarView
    private lateinit var selectedDate: Calendar
    private var previousMonthSelectedDateView: View? = null // Store previous month selection view
    private var nextMonthHighlightColor = Color.CYAN // Customizable next month highlight color

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calendar)

        calendarView = findViewById(R.id.calendarView)
        selectedDate = Calendar.getInstance()

        val textView = findViewById<TextView>(R.id.idTVDate)

        // Update text view and calculate next month details
        calendarView.setOnDateChangeListener { view, year, month, dayOfMonth ->
            selectedDate.set(year, month, dayOfMonth)
            textView.text = String.format("%d-%02d-%02d", year, month + 1, dayOfMonth) // Format with leading zeros

            val nextMonth = Calendar.getInstance()
            nextMonth.set(year, month + 1, 1) // Set to first day of next month

            // Clear previous selection highlights (if any)
            previousMonthSelectedDateView?.setBackgroundColor(Color.TRANSPARENT)

            // **Highlighting logic:**
            val currentYear = calendarView.date / 1000000000L // Extract year (avoid data loss)
            val currentMonth = (calendarView.date / 1000000 % 100) - 1 // Extract month (adjust for 0-based indexing)

            // Check if selected date is in the previous month
            if (month.toLong() == currentMonth - 1) {
                // Selected date is in the previous month
                val calendar = Calendar.getInstance()
                calendar.set(year, month, 1) // Set to first day of the month
                val actualMaxWeek = calendar.getActualMaximum(Calendar.WEEK_OF_MONTH) // Get actual number of weeks
                val selectedDay = calendarView.getChildAt(month * actualMaxWeek + dayOfMonth - 1)
                previousMonthSelectedDateView = selectedDay
                selectedDay?.setBackgroundColor(Color.YELLOW) // Highlight color for previous month selection

                // Highlight corresponding date in next month's view (implementation varies)
                val nextMonthCalendarView = getNextMonthCalendarView(calendarView)
                if (nextMonthCalendarView != null) {
                    val calendar = Calendar.getInstance()
                    calendar.set(year, month + 1, 1) // Set to first day of next month
                    val actualMaxWeek = calendar.getActualMaximum(Calendar.WEEK_OF_MONTH) // Get actual number of weeks
                    val nextMonthSelectedDay = nextMonthCalendarView.getChildAt(
                        (month + 1) * actualMaxWeek + dayOfMonth - 1
                    )
                    nextMonthSelectedDay?.setBackgroundColor(nextMonthHighlightColor)
                } else {
                    // Handle case where next month view is not readily available (consider logging or displaying a message)
                }
            } else {
                // Selected date is not in the previous month, so clear previous month highlight
                previousMonthSelectedDateView?.setBackgroundColor(Color.TRANSPARENT)
            }
        }
    }

    // Function to potentially retrieve the next month's calendar view (implementation may vary)
    private fun getNextMonthCalendarView(calendarView: CalendarView): CalendarView? {
        // This is a simplified example using reflection. Modify based on your library.
        try {
            val parent = calendarView.parent as ViewGroup
            val childCount = parent.childCount
            for (i in 0 until childCount) {
                val child = parent.getChildAt(i)
                if (child is CalendarView && child.id != calendarView.id) {
                    return child
                }
            }
        } catch (e: Exception) {
            // Handle potential exceptions (e.g., logging)
        }
        return null
    }
}