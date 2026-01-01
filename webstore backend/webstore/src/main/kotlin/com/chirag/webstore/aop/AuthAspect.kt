package com.chirag.webstore.aop

import com.chirag.webstore.auth.JwtService
import org.aspectj.lang.JoinPoint
import org.aspectj.lang.annotation.Aspect
import org.aspectj.lang.annotation.Before
import org.springframework.stereotype.Component
import org.springframework.web.context.request.RequestContextHolder
import org.springframework.web.context.request.ServletRequestAttributes

@Aspect
@Component
class AuthAspect(
    private val jwtService: JwtService
) {
    @Before("@annotation(com.chirag.webstore.aop.RequireAuth)")
    fun validateAuth(joinPoint: JoinPoint) {
        val request = (RequestContextHolder.getRequestAttributes() as ServletRequestAttributes).request

        // SKIP AUTH FOR OPTIONS (Preflight)
        if (request.method.equals("OPTIONS", ignoreCase = true)) {
            return
        }

        val cookies = request.cookies ?: throw RuntimeException("Missing token")

        val token = cookies.firstOrNull {it.name == "jwt"}?.value
            ?: throw RuntimeException("Missing token")

        if (!jwtService.validateToken(token)) {
            throw RuntimeException("Invalid or expired token")
        }
    }
}