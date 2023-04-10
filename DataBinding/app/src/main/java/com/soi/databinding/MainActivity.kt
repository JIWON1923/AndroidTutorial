package com.soi.databinding

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.soi.databinding.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        val btn = findViewById<Button>(R.id.testBtnID)
//        btn.setOnClickListener {
//            Toast.makeText(this, "click", Toast.LENGTH_LONG).show()
//        }

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.testBtnID.setOnClickListener {
            Toast.makeText(this, "click", Toast.LENGTH_LONG).show()
            Log.e("MainActivity", "testLog") // 오류
            Log.w("MainActivity", "testLog") // 경고
            Log.i("MainActivity", "testLog") // 정보
            Log.d("MainActivity", "testLog") // 디버그
            Log.v("MainActivity", "testLog") // 상세
        }

    }
}