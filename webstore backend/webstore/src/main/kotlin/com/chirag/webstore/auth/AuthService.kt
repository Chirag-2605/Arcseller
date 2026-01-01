package com.chirag.webstore.auth

import com.chirag.webstore.auth.dto.LoginDTO
import com.chirag.webstore.auth.dto.SignupDTO
import com.chirag.webstore.exceptions.ResourceNotFoundException
import com.chirag.webstore.exceptions.UserAlreadyExistException
import com.chirag.webstore.user.UserRepository
import org.springframework.stereotype.Service


@Service
class AuthService (
    private val userRepository: UserRepository,
    private val authMapper: AuthMapper
    ) {

    fun handleSignup (signupDTO: SignupDTO) : Pair<Boolean, String> {
        val user = userRepository.findByUsername(signupDTO.username)
        if(user != null) {
            throw UserAlreadyExistException("User already exists with username: ${signupDTO.username}")
        }
        val newUser = authMapper.mapToUser(signupDTO)
        userRepository.save(newUser)
        return true to "User created"
    }

    fun handleLogin (loginDto:LoginDTO) : Pair<Boolean, String> {
        val user = userRepository.findByUsername(loginDto.username)
            ?: throw ResourceNotFoundException("No user found with username: ${loginDto.username}")
        if(user.passwordHash != authMapper.hash(loginDto.password)) {
            return false to "Wrong password"
        }
        return true to "User found"
    }
}