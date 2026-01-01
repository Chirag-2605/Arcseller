import React from "react";
import styles from "./AuthLayout.module.css";

type AuthLayoutProps = {
    children: React.ReactNode;
    title?: string;
}

const AuthLayout = ({children, title} : AuthLayoutProps) => {
    return (
        <div className={styles.container}>
            <div className={styles.card}>
                {title && <h1 className={styles.title}>{title}</h1>}
                {children}
            </div>
        </div>
    )
}

export default AuthLayout