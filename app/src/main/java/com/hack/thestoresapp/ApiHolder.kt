package com.hack.thestoresapp

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiHolder {

    @POST("users/")
    fun register(@Body user: User): Call<Token>?

    @POST("token/login/")
    fun login(@Body loginDetails: loginDetails): Call<Token>?
}