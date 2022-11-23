import { User } from "./User";
export class Student {
    id?: number;
    name: string;
    surname: string;
    documentNumber: string;
    date: string;
    deleted: boolean = false;
    userEntity: User;
    constructor(name:string, surname:string,documentNumber:string,date:string,userEntity:User){
        this.name=name;
        this.surname=surname;
        this.documentNumber=documentNumber;
        this.date=date;
        this.deleted;
        this.userEntity=userEntity;
    }
}