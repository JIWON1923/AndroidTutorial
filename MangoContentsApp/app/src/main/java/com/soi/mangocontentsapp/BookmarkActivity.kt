package com.soi.mangocontentsapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.database.ktx.getValue
import com.google.firebase.ktx.Firebase

class BookmarkActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth
    private val contentModel = mutableListOf<ContentModel>()

    override fun onCreate(savedInstanceState: Bundle?) {

        auth = Firebase.auth

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bookmark)

        val database = Firebase.database
        val bookmartRef = database.getReference("bookmark")

        val recyclerView = findViewById<RecyclerView>(R.id.bookmarkRecyclerView)
        val adapter = RecyclerViewAdapter(this, contentModel)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = GridLayoutManager(this, 2)

        bookmartRef.child(auth.currentUser?.uid.toString())
            .addValueEventListener(object : ValueEventListener {
                override fun onDataChange(dataSnapshot: DataSnapshot) {
                    for (dataModel in dataSnapshot.children) {
                        Log.d("DataModel", dataModel.getValue().toString())
                        contentModel.add(dataModel.getValue(ContentModel::class.java)!!)
                    }

                    adapter.notifyDataSetChanged()
                }

                override fun onCancelled(error: DatabaseError) {
                    // Failed to read value
                    Log.e("Bookmark", "Failed to read value.")
                }
        })
    }
}