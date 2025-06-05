class Item {
    itemName: string;
    itemPrice: number;
    itemPriceCurrency: string;

    constructor(itemName: string, itemPrice: number, itemPriceCurrency: string) {
        this.itemName = itemName;
        this.itemPrice = itemPrice;
        this.itemPriceCurrency = itemPriceCurrency;
    }
}

export default Item;