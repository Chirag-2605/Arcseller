import styles from "./Landing.module.css"
import { useNavigate } from "react-router-dom"

const Landing = () => {

    const navigate = useNavigate()

    return (
        <div className={styles.container}>
            <h1>Welcome to our webstore.</h1>
            <h3>Login or signup to continue shopping</h3>
            <div>
                <button 
                    className={styles.button}
                    onClick={() => navigate("/login")}
                >Login</button>
                <button 
                    className={styles.button}
                    onClick={() => navigate("/signup")}
                >Signup</button>
            </div>
        </div>
    )
}

export default Landing