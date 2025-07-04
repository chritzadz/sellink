import Header from './components/Header';
import CategoryFrame from "./components/CategoryFrame";
import {firestore} from "./database/database";
import {useEffect, useState} from "react";
import {collection, onSnapshot} from "firebase/firestore"

interface Category {
    name: string;
}

function App() {
    const [categories, setCategories] = useState<Category[]>([]); //use type because typescript
    useEffect(
        () =>
            //for now we are gonna use chris_restaurant. I will make an account feature
            onSnapshot(collection(firestore, "store/chris_restaurant/categories/"), (snapshot) =>
                setCategories(snapshot.docs.map(doc => (
                    {id: doc.id, name: doc.id}
                )
            ))
        ), []);

    return (
        <>
            <div><Header/></div>
            <div className = "">
                {categories.map((category, index) => (
                    <CategoryFrame categoryName={category.name} categoryIndex={index} />
                ))}
            </div>
        </>
    );
}

export default App;