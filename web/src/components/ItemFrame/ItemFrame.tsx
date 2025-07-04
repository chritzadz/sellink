import pandaLogo from './panda_with_cord.jpg';
import type Item from "../../model/Item.ts";

interface ItemFrameProps {
    index: number;
    item: Item;
}

function ItemFrame({ index, item }: ItemFrameProps) {
    return (
        <div className="w-54 h-74 mr-3 flex-shrink-0 shadow-md"> {/* Static width and height */}
            <div>
                <img className="box-border object-cover w-54 h-46" src={pandaLogo} alt="panda"/>
            </div>
            <p className="pl-2 pr-2 mt-2 mb-0 text-base font-bold">{item.itemName}</p>
            <p className="pl-2 pr-2 mt-0.5 mb-0 text-xs overflow-hidden line-clamp-2">Description of the produc dwad d wa d adwad i wanna make this long test lol lo l ol </p>
            <p className="pl-2 pr-2 mt-0.5 mb-0 text-lg font-bold">{item.itemPriceCurrency} {item.itemPrice}</p>
        </div>
    );
}

export default ItemFrame;