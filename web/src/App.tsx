import Header from './components/Header';
import CategoryFrame from "./components/CategoryFrame";

function App() {
    const categoriesExample = [
        "Bla",
        "Ble",
        "Bli"
    ]

    return (
        <>
            <div><Header/></div>
            <div>
                {categoriesExample.map((category, index) => (
                    <CategoryFrame key={index} categoryName={category} />
                ))}
            </div>
        </>
    );
}

export default App;