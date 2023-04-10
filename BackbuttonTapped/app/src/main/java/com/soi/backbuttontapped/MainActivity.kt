package com.soi.backbuttontapped

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private var isDoubleTapped = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onBackPressed() {
        Log.d("Main", "backbutton")

        if (isDoubleTapped) {
            finish()
        }

        isDoubleTapped = true
        Toast.makeText(this, "종료하시려면, 한 번 더 눌러주세요.", Toast.LENGTH_SHORT).show()

        Handler().postDelayed({
            isDoubleTapped = true
        }, 2000)
    }
}