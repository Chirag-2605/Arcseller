import { useState } from "react"
import styles from "./AuthLayout/AuthLayout.module.css"
import { handleLogin } from "../services/auth.service"

import type { LoginPayload } from "../types"
import { useNavigate } from "react-router-dom"

const LoginForm = () => {

    const [formData, setFormData] = useState<LoginPayload>({
        username: "",
        password: ""
    })
    
    const navigate = useNavigate()

    const handleSubmit = async (e: React.FormEvent) => {
        e.preventDefault()
        try {
            const response = await handleLogin(formData)
            if(response.status) {
                console.log("Login successful:", response.message)
                localStorage.setItem("username", formData.username)
                navigate("/home")
            }
            else console.log("Login failed:", response.message)
        } catch (error) {
            console.log("Login failed:", error)
        }
        setFormData({username: "", password: ""})
    }

    return (
        <div>
            <form className={styles.form} onSubmit={handleSubmit}>
                <input 
                    type="text" 
                    placeholder="Username" 
                    name="username" 
                    value={formData.username}
                    onChange={(e) => {setFormData({...formData, username: e.target.value})}} />
                <input 
                    type="password" 
                    placeholder="Password" 
                    name="password" 
                    value={formData.password}
                    onChange={(e) => {setFormData({...formData, password: e.target.value})}} />
                <button className={styles.button} type="submit">Login</button>
            </form>
        </div>
    )
}

export default LoginForm