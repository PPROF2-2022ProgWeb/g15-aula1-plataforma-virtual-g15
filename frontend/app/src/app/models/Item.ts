export class Item {
  title:string;
  description:string;
  price:number;
  quantity:number;
  constructor( title:string,
    description:string,
    price:number,
    quantity:number){
      this.title =title;
      this.description = description;
      this.price = price;
      this.quantity = quantity;
    }
}
