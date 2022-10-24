import { User } from "./User";

export class Institution {    
    id?: number;
    name: string;
    cuitNumber: string;
    deleted: boolean = false;
    userEntity: User;
    constructor(name:string, cuitNumber:string,userEntity:User){
        this.name=name;
        this.cuitNumber=cuitNumber;
        this.deleted;
        this.userEntity=userEntity;
    }
}