package com.chirag.webstore.auth

import com.chirag.webstore.auth.dto.AuthResponse
import com.chirag.webstore.auth.dto.LoginDTO
import com.chirag.webstore.auth.dto.SignupDTO
import jakarta.servlet.http.Cookie
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("/api/users")
@CrossOrigin(
    origins = ["http://localhost:5173"],
    allowCredentials = "true"
)
class AuthController (
    private val authService: AuthService,
    private val jwtService: JwtService
    ) {

    @PostMapping("/signup")
    fun handleSignup(@RequestBody user: SignupDTO, response: HttpServletResponse) : AuthResponse {
        val (status, msg) = authService.handleSignup(user)
        return if(status) {
            val token = jwtService.generateToken(user.username)

            val cookie = Cookie("jwt", token)
            cookie.isHttpOnly = true
            cookie.secure = false
            cookie.path = "/"
            cookie.maxAge = 60*60

            response.addCookie(cookie)
            AuthResponse(true, msg)
        } else {
            AuthResponse(false, msg)
        }
    }

    @PostMapping("/login")
    fun handleLogin(@RequestBody user: LoginDTO, response: HttpServletResponse) : AuthResponse {
        val (status, msg) = authService.handleLogin(user)
        return if(status) {
            val token = jwtService.generateToken(user.username)

            val cookie = Cookie("jwt", token)
            cookie.isHttpOnly = true
            cookie.secure = false
            cookie.path = "/"
            cookie.maxAge = 60 * 60

            response.addCookie(cookie)
            AuthResponse(true, msg)
        } else {
            AuthResponse(false, msg)
        }
    }

    @GetMapping("/me")
    fun getCurrentUser(request: HttpServletRequest): Map<String, Any> {
        val cookies = request.cookies ?: return mapOf("authenticated" to false)

        val token = cookies.firstOrNull { it.name == "jwt" }?.value
            ?: return mapOf("authenticated" to false)

        return try {
            val username = jwtService.extractUsername(token)
            mapOf("authenticated" to true, "username" to username)
        } catch (e: Exception) {
            mapOf("authenticated" to false)
        }
    }
}