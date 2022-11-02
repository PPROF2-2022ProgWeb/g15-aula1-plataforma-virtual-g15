export class Invoice{
    id?:number;
    date:string;
    deleted?:boolean;
    invoiceTypeId:number;
    saleId:number;
    userId:number;
    constructor(date:string,invoiceTypeId:number, saleId:number, userId:number)
    {
        this.date=date;
        this.invoiceTypeId=invoiceTypeId;
        this.saleId=saleId;
        this.userId=userId;
    }
}