import Header from './components/Header';
import CategoryFrame from "./components/CategoryFrame";
import FilterFrame from "./components/FilterFrame";
import {firestore} from "./database/database";
import {useEffect, useState} from "react";
import {collection, onSnapshot} from "firebase/firestore"
import Category from "./model/Category";


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
            <div className='overflow-hidden max-w-full'><Header/></div>
            <div className='overflow-hidden max-w-full'>
                <FilterFrame categories={categories}/>
            </div>
            <div className = "overflow-hidden max-w-full">
                {categories.map((category, index) => (
                    <div className='mx-5'>
                        <CategoryFrame categoryName={category.name} categoryIndex={index} />
                    </div>
                ))}
            </div>
        </>
    );
}

export default App;