package com.soi.lifequotesapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView

class SentenceActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sentence)

        val lifeQuotes = mutableListOf<String>()

        lifeQuotes.add("검정 화면에 대충 흰 글씨 쓰면 명언 같다.")
        lifeQuotes.add("과거에 연연하지 마세요.")
        lifeQuotes.add("자기 자신을 사랑하세요.")
        lifeQuotes.add("땀 없인 달콤함도 없다.")
        lifeQuotes.add("주사위는 던져졌다.")
        lifeQuotes.add("난 혼자 있을 때 가장 외롭지 않았다.")


        val adapter = ListViewAdapter(lifeQuotes)
        val listView = findViewById<ListView>(R.id.sentenceListView)

        listView.adapter = adapter
    }
}