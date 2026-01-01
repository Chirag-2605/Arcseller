import styles from './ProductCard.module.css';
import demoImg from '../../../../assets/images/product_demo_img.jpg';
import type { Product } from '../../types';

const ProductCard = ({product, handleClick}: {key: number, product: Product, handleClick: (product:Product) => void}) => {
    return (
        <div className={styles.card} onClick={() => handleClick(product)}>
            <div className={styles.imageWrapper}>
                <img
                    src={product.imageUrl || demoImg}
                    alt="Product"
                    className={styles.image}
                />
            </div>

            <h2 className={styles.title}>{product.productName}</h2>

            <p className={styles.price}>${product.price}</p>
        </div>
    )
}

export default ProductCard;