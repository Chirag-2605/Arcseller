package com.chirag.webstore.product

import com.chirag.webstore.product.dto.ProductDto
import com.chirag.webstore.product.dto.ProductResponseDto
import org.springframework.stereotype.Component

@Component
class ProductMapper {
    fun mapToProduct (productDto: ProductDto) : Product {
        return Product (
            null, productDto.productName, productDto.productDescription, productDto.price, productDto.imageUrl,
            productDto.category, productDto.ownerName, productDto.createdAt
                )
    }
    fun mapToProductResponseDto (product: Product) : ProductResponseDto {
        val id = product.id
            ?: throw IllegalStateException("Product ID is null. Entity not persisted yet.")
        return ProductResponseDto (
            id, product.productName, product.price, product.productDescription, product.imageUrl, product.category,
            product.ownerName, product.createdAt
                )
    }
}