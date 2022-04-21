package com.example.brcommobileimovelparatodos

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class Login : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val btnLogin = findViewById<TextView>(R.id.entrar)
        btnLogin.setOnClickListener{
            val intent = Intent(this, HomeTest::class.java)
            startActivity(intent)
        }
    }
}