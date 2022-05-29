package com.example.brcommobileimovelparatodos

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity

    import android.os.Bundle
    import android.widget.*
    import androidx.core.content.ContextCompat
    import androidx.core.view.ViewCompat

    class MainActivity : AppCompatActivity() {
        private val context: Context get() = this
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val acessarMin = findViewById<TextView>(R.id.acessar_min)
        acessarMin.setOnClickListener{
            val intent = Intent(context, Login::class.java)
            startActivity(intent)
        }

        val btnCadastro = findViewById<TextView>(R.id.quero_me_cadastrar)
        btnCadastro.setOnClickListener{
            val intent1 = Intent(this, RegsisterActivity::class.java)
            startActivity(intent1)
        }
    }
        
}