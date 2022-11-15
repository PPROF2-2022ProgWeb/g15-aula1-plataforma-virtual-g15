import { Institution } from "./Institution";

export class Course{
    id?:number;
    name:string;
    description:string;
    beginningDay:string;
    endingDay:string;
    deleted?:boolean;
    institutions: Array<Institution>;
    constructor(name:string,
        description:string,
        beginningDay:string,
        endingDay:string,
        institutions: Array<Institution>){
            this.name=name;
    }
}
