package com.example.brcommobileimovelparatodos

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import com.example.brcommobileimovelparatodos.dto.*
import okhttp3.Request

class RegsisterActivity : AppCompatActivity() {
    val httpRequestHelper : HttpRequestHelper = HttpRequestHelper()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_regsister)

        val btnLogin = findViewById<TextView>(R.id.register_finalizar_cadastro)
        btnLogin.setOnClickListener{
            registerHandler()
        }
    }

    private fun register(input : DefaultResponseDto){
        if (!httpRequestHelper.isValidResult(input?.statusCode!!)){
            println("Error on request to login")
        }

        finish()
    }

    private fun registerHandler(){
        val email = findViewById<EditText>(R.id.register_login).text.toString()
        val name = findViewById<EditText>(R.id.register_name).text.toString()
        val password = findViewById<EditText>(R.id.register_password).text.toString()

        val requestBody = httpRequestHelper.createBody(SingUpRequestDto(name, email, password))

        val request = Request.Builder()
            .url("http://10.0.2.2:5000/users")
            .method("POST", requestBody)
            .build()

        httpRequestHelper.defaultRequest(request, ::register)
    }
}