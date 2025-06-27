class Item {
    itemName: string;
    itemPrice: number;
    itemPriceCurrency: string;
    itemCategory: string;

    constructor(itemName: string, itemPrice: number, itemPriceCurrency: string, itemCategory: string) {
        this.itemName = itemName;
        this.itemPrice = itemPrice;
        this.itemPriceCurrency = itemPriceCurrency;
        this.itemCategory = itemCategory;
    }
}

export default Item;