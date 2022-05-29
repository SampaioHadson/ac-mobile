package com.example.brcommobileimovelparatodos
import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.brcommobileimovelparatodos.dto.LoginResponseDto
import com.example.brcommobileimovelparatodos.dto.RequestResponseDto
import okhttp3.Request


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
            sharedPreferencesHelper.putStringPreference(this,"token", input.response?.token!!)
        }
        val intent = Intent(this, HomeTest::class.java)
        startActivity(intent)
    }

    private fun loginHandler(){
        val request = Request.Builder()
            .url("http://10.0.2.2:9000/login")
            .method("GET", null)
            .build();

        httpRequestHelper.request(request, ::login)
    }
}