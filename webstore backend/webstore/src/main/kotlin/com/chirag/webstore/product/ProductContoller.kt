package com.chirag.webstore.product

import com.chirag.webstore.aop.RequireAuth
import com.chirag.webstore.product.dto.ProductResponseDto
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/products")
@CrossOrigin(origins = ["http://localhost:5173"], allowCredentials = "true")
class ProductController (
    private val productService: ProductService
    ) {

        @GetMapping
        @RequireAuth
        fun getItems() : List<ProductResponseDto> {
            return productService.getItems()
        }

        @GetMapping("/{productId}")
        @RequireAuth
        fun getProductById(@PathVariable productId: Long) : ProductResponseDto {
            return productService.getProductById(productId)
        }
}