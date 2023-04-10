package com.soi.lifequotesapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.soi.lifequotesapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val lifeQuotes = mutableListOf<String>()

        lifeQuotes.add("검정 화면에 대충 흰 글씨 쓰면 명언 같다.")
        lifeQuotes.add("과거에 연연하지 마세요.")
        lifeQuotes.add("자기 자신을 사랑하세요.")
        lifeQuotes.add("땀 없인 달콤함도 없다.")
        lifeQuotes.add("주사위는 던져졌다.")
        lifeQuotes.add("난 혼자 있을 때 가장 외롭지 않았다.")

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.allQuotesButton.setOnClickListener {
            val intent = Intent(this, SentenceActivity::class.java)
            startActivity(intent)
        }

        binding.mainQuote.setText(lifeQuotes.random())
    }
}