import { createBrowserRouter, Navigate } from "react-router-dom"
import { useEffect, useState, type ReactNode } from "react";

import Landing from "../pages/Landing/Landing";
import Login from "../pages/Auth/Login";
import Signup from "../pages/Auth/Signup";
import Homepage from "../pages/Home/Homepage";
import { api } from "../services/api";
import ProductDetails from "../features/products/pages/ProductDetails";

type ProtectedRouteProps = {
    children: ReactNode
}

const checkAuth = async () => {
    try {
        const res = await api("/users/me", {
            method: "GET",
            credentials: "include",
        })
        return res.authenticated;
    } catch (error) {
        console.error("Authentication check failed:", error);
        return false
    }
}

const ProtectedRoute = ({ children } : ProtectedRouteProps) => {
    const [authenticated, setAuthenticated] = useState<boolean | null>(null);
    useEffect(() => {
        const verifyAuth = async () => {
            const isAuthenticated = await checkAuth()
            setAuthenticated(isAuthenticated)
        }
        verifyAuth()
    }, [])

    if (authenticated === null) {
        return <div>Loading...</div>;
    }

    if (!authenticated) {
        return <Navigate to="/login" replace />;
    }
    return children;
}   

const PublicRoute = ({ children } : {children : ReactNode}) => {
    const [authenticated, setAuthenticated] = useState<boolean | null>(null);
    useEffect(() => {
        const verifyAuth = async () => {
            const isAuthenticated = await checkAuth()
            setAuthenticated(isAuthenticated)
        }
        verifyAuth()
    }, [])
    if (authenticated === null) {
        return <div>Loading...</div>;
    }

    if(authenticated) return <Navigate to="/home" replace />
    return children
}

export const router = createBrowserRouter([
    { 
        path: "/", 
        element: (
            <PublicRoute>
                <Landing />
            </PublicRoute>
        )},
    { 
        path: "/login", 
        element: (
            <PublicRoute>
                <Login />
            </PublicRoute>
        )},
    { 
        path: "/signup", 
        element: (
            <PublicRoute>
                <Signup />
            </PublicRoute>
        ) },
    { 
        path: "/home", 
        element: (
            <ProtectedRoute>
                <Homepage />
            </ProtectedRoute>
        )},
    {
        path: "/products/:productId",
        element: (
            <ProtectedRoute>
                <ProductDetails />
            </ProtectedRoute>
        )
    }
])