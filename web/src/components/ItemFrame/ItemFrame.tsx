import styles from './ItemFrame.module.css';
import pandaLogo from './panda_with_cord.jpg';
import type Item from "../../model/Item.ts";

interface ItemFrameProps {
    index: number;
    item: Item;
}

function ItemFrame({index, item} : ItemFrameProps) {
    return (
        <>
            <div className="rounded-lg border-2 m-2 p-4 flex flex-col items-center">
                <img className="rounded-lg" src={pandaLogo} alt="panda" />
                <p>{item.itemName}</p>
                <p>{item.itemPriceCurrency} {item.itemPrice}</p>
            </div>
        </>);
}

export default ItemFrame;