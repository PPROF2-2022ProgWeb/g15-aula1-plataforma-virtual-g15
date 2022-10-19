import { Course } from "./Course";
import { User } from "./User";

export class Institution {    
    id?: number;
    name: string;
    cuitNumber: string;
    deleted?: boolean;
    userEntity: User;
    courses?: Set<Course>;
    constructor(name:string, cuitNumber:string,documentNumber:string,date:string,userEntity:User, courses?:Set<Course>){
        this.name=name;
        this.cuitNumber=cuitNumber;
        this.userEntity=userEntity;
        this.courses=courses;
    }
}