import ListGroup from './components/ListGroup';
import Header from './components/Header';
import Item from './Model/Item';

function App() {
    const itemsExample = [
        new Item("Chris", 6, "USD"),
        new Item("Hello", 5, "IDR")
    ]

    return (
        <>
            <div><Header/></div>
            <div><ListGroup items={itemsExample} /></div>
        </>
    );
}

export default App;