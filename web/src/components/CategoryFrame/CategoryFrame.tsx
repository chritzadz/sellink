import styles from './CategoryFrame.module.css';
import ListGroup from "../ListGroup";
import Item from "../../model/Item.ts";

interface CategoryFrameProps {
    categoryName: string;
    categoryIndex: number;
}

function CategoryFrame({categoryName, categoryIndex}: CategoryFrameProps) {
    const itemsExample = [
        new Item("Chris", 6, "USD"),
        new Item("Hello", 5, "IDR"),
        new Item("Hello", 5, "IDR"),
        new Item("Hello", 5, "IDR")
    ]

    return (
        <>
            <div className={styles.general}>
                <h1>{categoryName}</h1>
                <ListGroup items={itemsExample} />
            </div>
        </>
    );
}

export default CategoryFrame;