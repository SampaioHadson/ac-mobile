package com.example.brcommobileimovelparatodos.dto

class RequestResponseDto<T> {
    var response : T?
    var statusCode : Int

    constructor(responseData : T?, statusCode : Int){
        this.response = responseData
        this.statusCode = statusCode
    }
}