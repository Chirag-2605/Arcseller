package com.chirag.webstore.user

import jakarta.persistence.*
import org.springframework.boot.autoconfigure.domain.EntityScan

@Entity
@Table(name="users")
class User (
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    var userId: Long? = null,

    @Column(name="username", unique = true, nullable = false)
    var username:String,

    @Column(name="email", unique = true, nullable = false)
    var email:String,

    @Column(name="date_of_birth", nullable = false)
    var dateOfBirth:String,

    @Column(name="password_hash", nullable = false)
    var passwordHash:String,
)