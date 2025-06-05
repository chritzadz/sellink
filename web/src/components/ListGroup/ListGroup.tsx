function ListGroup() {
    const items = [
        '1',
        '2',
        '3',
        '4'
    ]

    return (
        <>
            <ul className="list-group">
                {items.map((item) => <li key={item}>{item}</li>)}
            </ul>
        </>);
}

export default ListGroup;