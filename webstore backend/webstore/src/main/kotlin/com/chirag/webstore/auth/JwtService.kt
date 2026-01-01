package com.chirag.webstore.auth

import io.jsonwebtoken.Jwts
import io.jsonwebtoken.security.Keys
import org.springframework.stereotype.Service
import java.util.Date

@Service
class JwtService {
    private val secretKey = Keys.hmacShaKeyFor("my_super_secret_key_which_is_very_long_262004".toByteArray())

    fun generateToken(username:String) : String {
        val now = Date()
        val expiry = Date(now.time + 1000 * 60 * 60)

        return Jwts.builder()
            .subject(username)
            .issuedAt(now)
            .expiration(expiry)
            .signWith(secretKey)
            .compact()
    }

    fun validateToken(token:String) : Boolean {
        return try {
            Jwts.parser()
                .verifyWith(secretKey)
                .build()
                .parseSignedClaims(token)
            true
        } catch (e: Exception) {
            println("Gandi request")
            false
        }
    }

    fun extractUsername(token: String) : String {
        val claims = Jwts.parser()
            .verifyWith(secretKey)
            .build()
            .parseSignedClaims(token)
        return claims.payload.subject
    }
}