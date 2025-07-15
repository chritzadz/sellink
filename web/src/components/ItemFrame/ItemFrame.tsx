import pandaLogo from './jpg_44-2.jpg';
import type Item from "../../model/Item.ts";

interface ItemFrameProps {
    index: number;
    item: Item;
    isHovering: boolean;
    onHover: (hovering: number) => void;

}

function ItemFrame({ index, item, isHovering, onHover}: ItemFrameProps) {
    return (
        <div className={`bg-off-off-white w-full h-fit transition-transform duration-300 ease-in-out`} /*hover:scale-110 hover:z-20 relative*/
            onMouseEnter={() => onHover(index)} // Pass the index when hovering
            onMouseLeave={() => onHover(-1)}
>
            <div className="justify-center flex">
                <img className="pr-12 box-border object-cover w-full h-55" src={pandaLogo} alt="panda"/>
            </div>
            <p className="pr-12 mt-2 mb-0 text-base font-bold">{item.itemName}</p>
            <p className="pr-12 mt-0.5 mb-0 text-xs overflow-hidden line-clamp-2">Description of the produc dwad d wa d adwad i wanna make this long test lol lo l ol </p>
            <p className="pr-12 mt-0.5 mb-0 text-lg font-bold pb-2.5">{item.itemPriceCurrency} {item.itemPrice}</p>
        </div>
    );
}

export default ItemFrame;