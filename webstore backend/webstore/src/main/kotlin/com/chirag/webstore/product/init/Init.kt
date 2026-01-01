package com.chirag.webstore.product.init

import com.chirag.webstore.product.ProductMapper
import com.chirag.webstore.product.ProductRepository
import com.chirag.webstore.product.dto.ProductDto
import org.springframework.boot.CommandLineRunner
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class Init {
    @Bean
    fun initData (
        productRepository: ProductRepository,
        productMapper: ProductMapper
    ) : CommandLineRunner {
        return CommandLineRunner {
            if(productRepository.count() == 0L) {
                val products = listOf(
                    ProductDto(
                        productName = "Fan",
                        productDescription = "Bajaj fast fan",
                        price = 100.0,
                        imageUrl = "https://whiteteak.com/media/catalog/product/c/f/cf9-10011_1_.jpg",
                        category = "electronics",
                        ownerName = "Chirag",
                        createdAt = "12-10-2025"
                    ),
                    ProductDto(
                        productName = "Air Conditioner",
                        productDescription = "LG Dual Inverter AC with turbo mode",
                        price = 35000.0,
                        imageUrl = "https://lirp.cdn-website.com/eb0d1dad/dms3rep/multi/opt/Split+system+Air+Conditioner-640w.jpg",
                        category = "electronics",
                        ownerName = "Rahul",
                        createdAt = "18-05-2026"
                    ),
                    ProductDto(
                        productName = "Cupboard",
                        productDescription = "3 feet full wooden heavy cupboard",
                        price = 28000.0,
                        imageUrl = "https://chicteak.com/cdn/shop/products/CB009222_1_Ba_530x@2x.jpg?v=1646504433",
                        category = "furniture",
                        ownerName = "Aman",
                        createdAt = "10-07-2026"
                    ),
                    ProductDto(
                        productName = "Microwave Oven",
                        productDescription = "IFB 20L Solo Microwave Oven",
                        price = 6200.0,
                        imageUrl = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRXMiVDR7PWvFmXM-dbO-ar8XszGzXm8wQRDg&s",
                        category = "kitchen",
                        ownerName = "Priya",
                        createdAt = "04-11-2026"
                    ),
                    ProductDto (
                        productName = "Smart TV",
                        productDescription = "Sony Bravia 43-inch LED Smart TV",
                        price = 42000.0,
                        imageUrl = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQmjFEh5CpG0db1MrfzbHpBaZFGG1sD7vzwUw&s",
                        category = "electronics",
                        ownerName = "Vikram",
                        createdAt = "22-09-2027"
                    )
                )
                products.forEach { product ->
                    productRepository.save(productMapper.mapToProduct(product))
                }

                println("Products initialized successfully")
            }
        }
    }
}