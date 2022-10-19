import { Course } from "./Course";
import { User } from "./User";

export class Student {    
    id?: number;
    name: string;
    surname: string;
    documentNumber: string;
    date: string;
    deleted?: boolean;
    userEntity: User;
    courses?: Set<Course>;
    constructor(name:string, surname:string,documentNumber:string,date:string,userEntity:User, courses?:Set<Course>){
        this.name=name;
        this.surname=surname;
        this.documentNumber=documentNumber;
        this.date=date;
        this.userEntity=userEntity;
        this.courses=courses;
    }
}