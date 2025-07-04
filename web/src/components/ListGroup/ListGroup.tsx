import ItemFrame from '../ItemFrame';
import React, { useState } from 'react'
import type Item from "../../model/Item.ts";

interface ListGroupProps {
    items: Item[];
}

function ListGroup({ items }: ListGroupProps) {
    const [hoveredIndex, setHoveredIndex] = useState<number | null>(null);
    const handleHover = (index: number) => {
        setHoveredIndex(index === hoveredIndex ? null : index);
    };


    return (
        <div className="items-center h-84 flex flex-row overflow-x-scroll overflow-y-hidden scrollbar-hidden"> {/* Set height and overflow */}
            {items.map((item, index) => (
                <ItemFrame key={index} index={index} item={item} isHovering={hoveredIndex === index} onHover={handleHover}/>
            ))}
        </div>
    );
}

export default ListGroup;