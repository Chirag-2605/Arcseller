import styles from './ProductList.module.css';
import { useProducts } from '../../hooks/useProducts';
import ProductCard from '../ProductCard/ProductCard';
import type { Product } from '../../types';
import { useNavigate } from 'react-router-dom';

const ProductList = () => {

    const {products} =  useProducts();

    const navigate = useNavigate()

    const handleClick = (product:Product) => {
        const id = product.productId;
        console.log(id);
        navigate(`/products/${id}`);
    }

    return (
        <div className={styles.productList}>
                {products.map((product) => (
                    <ProductCard key={product.productId} product={product} handleClick={handleClick} />
                ))}
            </div>
    )
}

export default ProductList;