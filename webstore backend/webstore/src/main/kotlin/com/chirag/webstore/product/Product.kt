package com.chirag.webstore.product

import jakarta.persistence.*
import java.util.Date
import java.util.UUID

@Entity
@Table (name = "products")
class Product (
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    var id: Long? = null,
    @Column(name="product_name")
    var productName: String,
    @Column(name="product_description")
    var productDescription: String,
    @Column(name="price")
    var price: Double,
    @Column(name="image_url")
    var imageUrl: String,
    @Column(name = "category")
    var category: String,
    @Column(name="owner_name")
    var ownerName: String,
    @Column(name="created_at")
    var createdAt: String,
)
