import styles from './Navbar.module.css';

const Navbar = () => {
    return (
        <div className={styles.navbar}>
            <h1 className={styles.logo}>Arcseller</h1>

            <div className={styles.navItems}>
                <button className={styles.navBtn}>Home</button>
                <button className={styles.navBtn}>Products</button>
                <button className={styles.navBtn}>Logout</button>
            </div>
        </div>
    )
}

export default Navbar;