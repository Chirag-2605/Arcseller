package com.chirag.webstore.auth

import com.chirag.webstore.auth.dto.LoginDTO
import com.chirag.webstore.auth.dto.SignupDTO
import com.chirag.webstore.user.User
import org.springframework.stereotype.Component
import java.util.*

@Component
class AuthMapper {
    fun hash (password:String) : String {
        return "frontKey123@" + password + "readKey789"
    }
    fun mapToUser (signupDto:SignupDTO) : User {
        return User (
            userId = null,
            username = signupDto.username,
            email = signupDto.email,
            dateOfBirth = signupDto.dateOfBirth,
            passwordHash = hash(signupDto.password)
        )
    }
}