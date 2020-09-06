package com.hack.thestoresapp

data class User(
    val name:String,
    val phone_number:String,
    val email:String,
    val password:String,
    val role:String
)

data class Token(
    val auth_token:String
)

data class loginDetails(
    val name: String?,
    val email: String?,
    val password: String?
)