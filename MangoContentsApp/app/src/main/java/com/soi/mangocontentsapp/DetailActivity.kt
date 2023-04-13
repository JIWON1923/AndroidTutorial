package com.soi.mangocontentsapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView
import android.widget.TextView
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class DetailActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        auth = Firebase.auth

        val url = intent.getStringExtra("url").toString()
        val image = intent.getStringExtra("imageURL").toString()
        val title = intent.getStringExtra("title").toString()

        val webView = findViewById<WebView>(R.id.webView)
        webView.loadUrl(url)

        val database = Firebase.database
        val bookmarkReference = database.getReference("bookmark")

        val saveText = findViewById<TextView>(R.id.saveText)
        saveText.setOnClickListener {
            bookmarkReference
                .child(auth.currentUser!!.uid)
                .push()
                .setValue(ContentModel(url, image, title))
        }
    }
}