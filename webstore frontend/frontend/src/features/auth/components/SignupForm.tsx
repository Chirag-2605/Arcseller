import React, { useState } from "react"
import styles from "./AuthLayout/AuthLayout.module.css"
import type { SignupPayload } from "../types"
import { handleSignup } from "../services/auth.service"
import { useNavigate } from "react-router-dom"

const SignupForm = () => {

    const [formData, setFormData] = useState<SignupPayload>({
        username: "",
        password: "",
        email: "",
        dateOfBirth: ""
    })

    const navigate = useNavigate()

    const handleChange = (e: React.ChangeEvent<HTMLInputElement>) => {
        const {name,value} = e.target
        setFormData({...formData, [name]: value})
    }

    const handleSubmit = async (e: React.FormEvent) => {
        e.preventDefault()
        try {
            const response = await handleSignup(formData)
            if(response.status) {
                console.log("Signup successful:", response.message)
                localStorage.setItem("username", formData.username)
                navigate("/home")
            }
            else console.log("Signup failed:", response.message)
        } catch (error) {
            console.log("Signup failed:", error)
        }
        
        setFormData({username: "", password: "", email: "", dateOfBirth: ""})
    }

    return (
        <div>
            <form className={styles.form} onSubmit={handleSubmit}>
                <input 
                    type="text" 
                    placeholder="Username" 
                    name="username"
                    value={formData.username} 
                    onChange={handleChange}/>
                <input 
                    type="email" 
                    placeholder="Email" 
                    name="email"
                    value={formData.email} 
                    onChange={handleChange} />
                <input 
                    type="password" 
                    placeholder="Password" 
                    name="password"
                    value={formData.password} 
                    onChange={handleChange} />
                <input 
                    type="date" 
                    name="dateOfBirth"
                    placeholder="Date of Birth" 
                    value={formData.dateOfBirth} 
                    onChange={handleChange} />
                <button 
                    className={styles.button} 
                    type="submit">Signup</button>
            </form>
        </div>
    )
}

export default SignupForm