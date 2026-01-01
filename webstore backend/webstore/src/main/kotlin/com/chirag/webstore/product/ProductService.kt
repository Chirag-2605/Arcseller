package com.chirag.webstore.product

import com.chirag.webstore.exceptions.ResourceNotFoundException
import com.chirag.webstore.product.dto.ProductResponseDto
import org.springframework.stereotype.Service

@Service
class ProductService (
    private val productRepository: ProductRepository,
    private val productMapper: ProductMapper
        ) {

    fun getItems(): List<ProductResponseDto> {
        val productList = productRepository.findAll()
        return productList.map { product -> productMapper.mapToProductResponseDto(product) }
    }

    fun getProductById(productId: Long): ProductResponseDto {
        val product = productRepository.findById(productId)
            .orElseThrow { ResourceNotFoundException("No product exist with id: $productId") }
        return productMapper.mapToProductResponseDto(product)
    }
}