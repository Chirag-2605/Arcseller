const BASE_URL = "http://localhost:8080/api"

export const api = async (
    endpoint: string,
    options: RequestInit = {}
) => {
    const response = await fetch(`${BASE_URL}${endpoint}`, {
        credentials: "include",
        ...options,
        headers: {
            "Content-Type": "application/json",
            ...options.headers,
        },
    })
    if(!response.ok) {
        const error = await response.json()
        throw new Error(error.message || "API request failed")
    }
    return response.json()
}