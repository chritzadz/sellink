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
    const [items, setItems] = useState<Item[]>([]); //use type becaue typescript
    useEffect(
        () => {
            const itemsRef = collection(firestore, "items");
            const filterQuery = query(itemsRef, where("itemCategory", "==", categoryName));

            onSnapshot(filterQuery, (snapshot) =>
                setItems(snapshot.docs.map(doc =>  new Item(
                    doc.data().itemName,
                    doc.data().itemPrice,
                    doc.data().itemPriceCurrency
                )))
            ), [];
        });


    return (
        <>
            <div className={styles.general}>
                <h1>{categoryName}</h1>
                <ListGroup items={items} />
            </div>
        </>
    );
}

export default CategoryFrame;