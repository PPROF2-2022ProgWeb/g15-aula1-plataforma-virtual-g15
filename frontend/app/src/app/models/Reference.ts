import { Item } from "./Item";

export class Reference {
  accessToken:string;
  items:Array<Item>;
  constructor(accessToken:string,items:Array<Item>){
    this.accessToken=accessToken;
    this.items=items;
  }
}
