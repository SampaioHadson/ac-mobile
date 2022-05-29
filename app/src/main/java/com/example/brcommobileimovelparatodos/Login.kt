package com.example.brcommobileimovelparatodos
import android.content.Intent
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.beust.klaxon.Klaxon
import com.example.brcommobileimovelparatodos.dto.LoginRequestDto
import com.example.brcommobileimovelparatodos.dto.LoginResponseDto
import com.example.brcommobileimovelparatodos.dto.RequestResponseDto
import okhttp3.MediaType
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.Request
import okhttp3.RequestBody
import okhttp3.RequestBody.Companion.toRequestBody


class Login : AppCompatActivity() {
    val httpRequestHelper : HttpRequestHelper = HttpRequestHelper()
    val sharedPreferencesHelper : SharedPreferencesHelper = SharedPreferencesHelper()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val btnLogin = findViewById<TextView>(R.id.entrar)
        btnLogin.setOnClickListener{
            loginHandler()
        }
    }

    private fun login(input : RequestResponseDto<LoginResponseDto>){
        if (!httpRequestHelper.isValidResult(input?.statusCode!!)){
            println("Error on request to login")
        }else{
            sharedPreferencesHelper.putintegerPreference(this,"token", input.response?.token!!)
        }
        val intent = Intent(this, HomeTest::class.java)
        startActivity(intent)
    }

    private fun loginHandler(){
        val email = findViewById<EditText>(R.id.login).text.toString()
        val password = findViewById<EditText>(R.id.password).text.toString()
        val requestBody = httpRequestHelper.createBody(LoginRequestDto(email = email, password = password))

        val request = Request.Builder()
            .url("http://10.0.2.2:5000/users/login")
            .method("POST", requestBody)
            .build();

        httpRequestHelper.request(request, ::login)
    }
}