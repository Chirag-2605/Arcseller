package com.chirag.webstore.auth.dto

data class SignupDTO(
    val username: String,
    val password: String,
    val email: String,
    val dateOfBirth: String
)

data class LoginDTO(
    val username: String,
    val password: String,
)

data class AuthResponse (
    val status: Boolean,
    val message: String,
)
