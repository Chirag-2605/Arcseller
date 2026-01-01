import Navbar from "../../components/Navbar/Navbar";
import ProductList from "../../features/products/components/ProductList/ProductList";
import styles from './Homepage.module.css';

const Homepage = () => {
    return (
        <div className={styles.container}>
            <Navbar />
            <ProductList />
        </div>
    )
}

export default Homepage