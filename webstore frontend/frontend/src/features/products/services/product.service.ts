import { api } from "../../../services/api"

const getProducts = async () => {
    const response = await api("/products", {
        method: "GET",
    })
    return response;
}

const getProductById = async (productId: string) => {
    const response = await api(`/products/${productId}`, {
        method: "GET",
    })
    return response;
}

export { getProducts, getProductById };