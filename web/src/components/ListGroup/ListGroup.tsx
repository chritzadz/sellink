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
        <div className="flex flex-wrap w-full">
            {items.map((item, index) => (
                <div className='w-1/8'>
                    <ItemFrame key={index} index={index} item={item} isHovering={hoveredIndex === index} onHover={handleHover}/>
                </div>
            ))}
        </div>
    );
}

export default ListGroup;