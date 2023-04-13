package com.soi.ddaycounterapp

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.DatePicker
import android.widget.TextView
import java.util.Calendar
import java.util.GregorianCalendar
import java.util.concurrent.TimeUnit

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val startButton = findViewById<Button>(R.id.startButton)
        val endButton = findViewById<Button>(R.id.endButton)

        val calendarStart = Calendar.getInstance()
        val calendarEnd = Calendar.getInstance()

        startButton.setOnClickListener {
            val today = GregorianCalendar()
            val year = today.get(Calendar.YEAR)
            val month = today.get(Calendar.MONTH)
            val date = today.get(Calendar.DATE)

            val dialog = DatePickerDialog(this, object: DatePickerDialog.OnDateSetListener {
                override fun onDateSet(p0: DatePicker?, year: Int, month: Int, date: Int) {
                    calendarStart.set(year, month, date)
                }
            }, year, month, date)
            dialog.show()
        }

        endButton.setOnClickListener {
            val today = GregorianCalendar()
            val year = today.get(Calendar.YEAR)
            val month = today.get(Calendar.MONTH)
            val date = today.get(Calendar.DATE)

            val dialog = DatePickerDialog(this, object: DatePickerDialog.OnDateSetListener {
                override fun onDateSet(p0: DatePicker?, year: Int, month: Int, date: Int) {
                    calendarEnd.set(year, month, date+1)
                    val dayCount = TimeUnit.MILLISECONDS.toDays(calendarEnd.timeInMillis - calendarStart.timeInMillis)
                    findViewById<TextView>(R.id.ddayTextView).setText(dayCount.toString())
                }
            }, year, month, date)
            dialog.show()
        }
    }
}