import { useEffect, useState } from "react"
import { getProductById } from "../services/product.service"
import type { Product } from "../types"

export const useProductDetails = (productId?: string) => {
    const [product, setProduct] = useState<Product | null>(null)
    if(!productId) return {product: null}
    useEffect(() => {
        getProductById(productId).then((data) => {
            setProduct(data)
        })
    }, [])
    return {product}
}