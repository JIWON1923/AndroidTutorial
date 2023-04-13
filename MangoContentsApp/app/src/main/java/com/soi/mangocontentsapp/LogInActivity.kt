package com.soi.mangocontentsapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class LogInActivity : AppCompatActivity() {


    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_log_in)

        auth = Firebase.auth

        val joinButton = findViewById<Button>(R.id.joinButton)

        joinButton.setOnClickListener {

            val email = findViewById<EditText>(R.id.emailArea)
            val password = findViewById<EditText>(R.id.passwordArea)

            auth.createUserWithEmailAndPassword(email.text.toString(), password.text.toString())
                .addOnCompleteListener(this) { task ->
                    if (task.isSuccessful) {
                        val intent = Intent(this, MainActivity::class.java)
                        startActivity(intent)
                        val user = auth.currentUser
                    } else {

                    }
                }
        }
    }
}