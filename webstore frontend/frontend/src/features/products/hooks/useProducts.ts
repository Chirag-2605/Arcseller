import { useEffect, useState } from "react"
import type { Product } from "../types"
import { getProducts } from "../services/product.service"

export const useProducts = () => {
    const [products, setProducts] = useState<Product[]>([])

    useEffect(() => {
        getProducts().then((data) => {
            setProducts(data)
        })
        console.log(products);
    }, [products.length])
    return {products}
}