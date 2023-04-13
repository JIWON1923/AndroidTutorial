package com.soi.mangocontentsapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private val items = mutableListOf<ContentModel>()
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val bookmark = findViewById<TextView>(R.id.bookmark)
        bookmark.setOnClickListener {
            val intent = Intent(this, BookmarkActivity::class.java)
            startActivity(intent)
        }


        // recycler view 연결
        items.add(
            ContentModel(
                    "https://www.mangoplate.com/restaurants/idf086yTzsn9",
                "https://mp-seoul-image-production-s3.mangoplate.com/1514074_1595943058420449.jpg?fit=around|512:512&crop=512:512;*,*&output-format=jpg&output-quality=80",
                "숙성도"
            )
        )
        items.add(
            ContentModel(
                "https://www.mangoplate.com/restaurants/UEmRRThzZP",
                "https://mp-seoul-image-production-s3.mangoplate.com/905373_1681052358526875.jpg?fit=around|512:512&crop=512:512;*,*&output-format=jpg&output-quality=80",
                "스시호시카이"
            )
        )
        items.add(
            ContentModel(
                "https://www.mangoplate.com/restaurants/0b91aGscz-",
                "https://mp-seoul-image-production-s3.mangoplate.com/sources/web/restaurants/183680/1062290_1594966931482?fit=around|512:512&crop=512:512;*,*&output-format=jpg&output-quality=80",
                "상춘재"
            )
        )
        items.add(
            ContentModel(
                "https://www.mangoplate.com/restaurants/QQO5xTBZgP89",
                "https://mp-seoul-image-production-s3.mangoplate.com/added_restaurants/294426_1490510584369174.jpg?fit=around|512:512&crop=512:512;*,*&output-format=jpg&output-quality=80",
                "오드랑베이커리 "
            )
        )
        items.add(
            ContentModel(
                "https://www.mangoplate.com/restaurants/idf086yTzsn9",
                "https://mp-seoul-image-production-s3.mangoplate.com/1514074_1595943058420449.jpg?fit=around|512:512&crop=512:512;*,*&output-format=jpg&output-quality=80",
                "숙성도"
            )
        )
        items.add(
            ContentModel(
                "https://www.mangoplate.com/restaurants/UEmRRThzZP",
                "https://mp-seoul-image-production-s3.mangoplate.com/905373_1681052358526875.jpg?fit=around|512:512&crop=512:512;*,*&output-format=jpg&output-quality=80",
                "스시호시카이"
            )
        )
        items.add(
            ContentModel(
                "https://www.mangoplate.com/restaurants/0b91aGscz-",
                "https://mp-seoul-image-production-s3.mangoplate.com/sources/web/restaurants/183680/1062290_1594966931482?fit=around|512:512&crop=512:512;*,*&output-format=jpg&output-quality=80",
                "상춘재"
            )
        )
        items.add(
            ContentModel(
                "https://www.mangoplate.com/restaurants/QQO5xTBZgP89",
                "https://mp-seoul-image-production-s3.mangoplate.com/added_restaurants/294426_1490510584369174.jpg?fit=around|512:512&crop=512:512;*,*&output-format=jpg&output-quality=80",
                "오드랑베이커리 "
            )
        )

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        val adapter = RecyclerViewAdapter(baseContext, items)
        recyclerView.adapter = adapter

        adapter.itemClick = object: RecyclerViewAdapter.ItemClick {
            override fun onClick(view: View, position: Int) {
                val intent = Intent(baseContext, DetailActivity::class.java)
                intent.putExtra("url", items[position].url)
                intent.putExtra("title", items[position].titleText)
                intent.putExtra("imageURL", items[position].imageURL)

                startActivity(intent)
            }
        }

        recyclerView.layoutManager = GridLayoutManager(this, 2)

    }
}