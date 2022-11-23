export class Sale{
    id?:number;
    productQuantity:number;
    totalPrice:number;
    deleted?:boolean;
    productId:number;
    constructor(productQuantity:number,
        totalPrice:number,
        productId:number)
    {
        this.productQuantity=productQuantity;
        this.totalPrice=totalPrice;
        this.productId=productId;
    }
}