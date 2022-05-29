package com.example.brcommobileimovelparatodos.dto

import com.beust.klaxon.Json

data class LoginResponseDto(
    @Json(name = "id")
    val token: Int
)