import styles from './ItemFrame.module.css';
import pandaLogo from './panda_with_cord.jpg';
import type Item from "../../Model/Item.ts";

interface ItemFrameProps {
    index: number;
    item: Item;
}

function ItemFrame({index, item} : ItemFrameProps) {
    return (
        <>
            <div className={styles.general}>
                <img src={pandaLogo} alt="panda" />
                <p>{item.itemName}</p>
                <p>{item.itemPriceCurrency} {item.itemPrice}</p>
            </div>
        </>);
}

export default ItemFrame;