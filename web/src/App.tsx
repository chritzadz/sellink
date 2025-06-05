import Header from './components/Header';
import CategoryFrame from "./components/CategoryFrame";
import {firestore} from "./database/database";
import {useEffect, useState} from "react";
import {collection, onSnapshot} from "firebase/firestore"

interface Category {
    name: string;
}

function App() {
    const [categories, setCategories] = useState<Category[]>([]); //use type becaue typescript
    useEffect(
        () =>
            onSnapshot(collection(firestore, "category"), (snapshot) =>
                setCategories(snapshot.docs.map(doc => ({id: doc.id, name: doc.data().categoryName})),)
        ), []);

    return (
        <>
            <div><Header/></div>
            <div>
                {categories.map((category, index) => (
                    <CategoryFrame categoryName={category.name} categoryIndex={index} />
                ))}
            </div>
        </>
    );
}

export default App;