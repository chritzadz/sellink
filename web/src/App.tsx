import Header from './components/Header';
import CategoryFrame from "./components/CategoryFrame";
import FilterFrame from "./components/FilterFrame";
import {firestore} from "./database/database";
import {useEffect, useState, useRef} from "react";
import {collection, onSnapshot} from "firebase/firestore"
import Category from "./model/Category";


function App() {
    const [categories, setCategories] = useState<Category[]>([]); //use type because
    const categoriesRef = useRef(new Map());

    useEffect(
        () =>
            //for now we are gonna use chris_restaurant. I will make an account feature
            onSnapshot(collection(firestore, "store/chris_restaurant/categories/"), (snapshot) =>
                setCategories(snapshot.docs.map(doc => (
                    {id: doc.id, name: doc.id}
                )
            ))
        ), []);

    const scrollToCategory = (categoryName: string) => {
        const element = document.getElementById(categoryName);
        if (element) {
            element.scrollIntoView({ behavior: 'smooth' });
        }
    };

    return (
        <div className="bg-off-off-white">
            <div className='overflow-hidden max-w-full fixed top-0 left-0 w-full z-10'><Header/></div>
            <div className="mt-15">
                <div className='overflow-hidden max-w-full'>
                <FilterFrame categories={categories} onCategoryClick={scrollToCategory}/>
            </div>
            <div className="overflow-hidden max-w-full">
                {categories.map((category, index) => (
                    <div
                        key={index}
                        className='mx-5'
                        id={category.name}
                    >
                        <CategoryFrame categoryName={category.name} categoryIndex={index}/>
                    </div>
                ))}
            </div>
            </div>
        </div>
    );
}

export default App;