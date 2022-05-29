package com.example.brcommobileimovelparatodos

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class ItemDetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var params = intent.getExtras()!!

        setContentView(R.layout.activity_item_details)

        var y = findViewById<ImageView>(R.id.item_details_image)
        y.setImageResource(params.getInt("icons"))

        var x = findViewById<TextView>(R.id.item_details_title)
        x.text = params.getString("title")

        val btnLogin = findViewById<TextView>(R.id.realizar_proposta)
        btnLogin.setOnClickListener{
            val intent = Intent(this, ProposalActivity::class.java)
            startActivity(intent)
        }

        val btnAgenda = findViewById<TextView>(R.id.agendar_visita)
        btnAgenda.setOnClickListener{
            val intent = Intent(this, ScheduleActivity::class.java)
            startActivity(intent)
        }
    }
}