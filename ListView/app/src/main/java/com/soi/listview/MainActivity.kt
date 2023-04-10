package com.soi.listview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // 어댑터 연결
        val listItem = mutableListOf<ListViewModel>()
        listItem.add(ListViewModel("a", "b"))
        listItem.add(ListViewModel("c", "d"))
        listItem.add(ListViewModel("e", "f"))

        val listView = findViewById<ListView>(R.id.mainListView)

        val adapter = ListViewAdapter(listItem)
        listView.adapter = adapter
    }
}