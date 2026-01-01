import { useParams } from "react-router-dom";

import { useProductDetails } from "../hooks/useProductDetails";
import styles from "./ProductDetails.module.css";

const ProductDetails = () => {

    const { productId } = useParams<{productId: string}>();

    const {product} = useProductDetails(productId);

    if(!product) return <div>Error: Product not found</div>

    return (
        <div className={styles.container}>
            <div className={styles.left}>
                <img
                    src={product.imageUrl}
                    alt={product.productName}
                    className={styles.productImage}
                />
            </div>

            <div className={styles.right}>
                <h1 className={styles.title}>{product.productName}</h1>
                <p className={styles.description}>{product.productDescription}</p>

                <p className={styles.category}>
                    Category: <span>{product.category}</span>
                </p>

                <p className={styles.owner}>
                    Owner: <span>{product.ownerName}</span>
                </p>

                <p className={styles.createdAt}>
                    Added on: <span>{product.createdAt}</span>
                </p>

                <p className={styles.price}>₹ {product.price}</p>

                <button className={styles.button}>Add to Cart</button>
            </div>
        </div>
    )
}

export default ProductDetails;