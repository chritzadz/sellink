import ItemFrame from '../ItemFrame';
import styles from './ListGroup.module.css';
import type Item from "../../model/Item.ts";

interface ListGroupProps {
    items: Item[];
}

function ListGroup({ items }: ListGroupProps) {
    return (
        <div className={styles.itemListGroup}>
            {items.map((item, index) => (
                <ItemFrame key={index} index={index} item={item} />
                ))}
        </div>
    );
}

export default ListGroup;