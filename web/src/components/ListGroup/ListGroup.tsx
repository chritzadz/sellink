import ItemFrame from '../ItemFrame';
import styles from './ListGroup.module.css';
import type Item from "../../model/Item.ts";

interface ListGroupProps {
    items: Item[];
}

function ListGroup({ items }: ListGroupProps) {
    return (
        <div className="h-76 flex flex-row overflow-x-scroll overflow-y-hidde scrollbar-hidden"> {/* Set height and overflow */}
            {items.map((item, index) => (
                <ItemFrame key={index} index={index} item={item} />
            ))}
        </div>
    );
}

export default ListGroup;