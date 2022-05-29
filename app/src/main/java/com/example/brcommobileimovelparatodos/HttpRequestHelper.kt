package com.example.brcommobileimovelparatodos

import com.beust.klaxon.Klaxon
import com.example.brcommobileimovelparatodos.dto.RequestResponseDto
import okhttp3.*
import java.io.IOException
import java.lang.Exception
import java.lang.reflect.Type
import kotlin.reflect.KFunction1

class HttpRequestHelper {
    var client: OkHttpClient = OkHttpClient().newBuilder().build();

    inline fun <reified T> request(request: Request, handler: KFunction1<RequestResponseDto<T>, Unit>) {
        try {
            client.newCall(request).enqueue(object : Callback{
                override fun onFailure(call: Call, e: IOException) {
                    println("")
                }
                override fun onResponse(call: Call, response: Response) {
                    val jsonString = response.body?.string();
                    val dto = RequestResponseDto(Klaxon().parse<T>(jsonString!!), response.code);
                    handler.invoke(dto)
                }
            })
        }catch (e : Exception){
            println("Error on handler request: " + e.message)
        }
    }

    public fun isValidResult(code : Int) : Boolean {
        return code in 200..299;
    }
}