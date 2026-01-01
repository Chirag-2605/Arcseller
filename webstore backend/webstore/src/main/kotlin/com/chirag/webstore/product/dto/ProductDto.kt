package com.chirag.webstore.product.dto

import java.util.*

data class ProductDto (
    val productName: String,
    val price: Double,
    val productDescription: String,
    val imageUrl: String,
    val category: String,
    val ownerName: String,
    val createdAt: String,
)

data class ProductResponseDto (
    val productId: Long,
    val productName: String,
    val price: Double,
    val productDescription: String,
    val imageUrl: String,
    val category: String,
    val ownerName: String,
    val createdAt: String,
)