export const useAuth = () => {
    const token = localStorage.getItem("token")
    const username = localStorage.getItem("username")

    return {
        isAuthenticated: !!token,
        username: username,
    }
}