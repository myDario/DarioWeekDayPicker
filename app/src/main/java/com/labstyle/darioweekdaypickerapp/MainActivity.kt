package com.labstyle.darioweekdaypickerapp

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.labstyle.darioweekdaypicker.DarioWeekDayPicker

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<DarioWeekDayPicker>(R.id.weekdayPicker).onSelectionChanged = {
            Log.d("dbg", "onSelectionChanged $it")
        }
    }
}