import styles from './CategoryFrame.module.css';
import ListGroup from "../ListGroup";
import Item from "../../model/Item.ts";
import {firestore} from "../../database/database";
import {useEffect, useState} from "react";
import {collection, onSnapshot, query, where} from "firebase/firestore"

interface CategoryFrameProps {
    categoryName: string;
    categoryIndex: number;
}

function CategoryFrame({categoryName, categoryIndex}: CategoryFrameProps) {
    const [items, setItems] = useState<Item[]>([]); //use type because typescript LOL
    useEffect(
        () => {
            const itemsRef = collection(firestore, `/store/chris_restaurant/categories/${categoryName}/good/`);

            onSnapshot(itemsRef, (snapshot) =>
                setItems(snapshot.docs.map(doc =>  new Item(
                    doc.id,
                    doc.data().price,
                    doc.data().currency,
                    categoryName
                )))
            ), [];
        });


    return (
        <>
            <div className="pl-2">
                <h1 className="text-4xl pb-2">{categoryName}</h1>
                <div> {/* Wrap ListGroup in a div */}
                    <ListGroup items={items} />
                </div>
            </div>
        </>
    );
}

export default CategoryFrame;