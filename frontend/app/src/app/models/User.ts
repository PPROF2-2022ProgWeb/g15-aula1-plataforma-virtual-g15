import { Student } from "./Student";

export class User {
    id?: number;
    email: string;
    password: string;
    deleted?: boolean;
    countryId: number;
    provinceId: number;
    cityId: number;
    studentEntity?: Student;
    institutionEntity?: string;
    constructor(email: string, password: string, countryId: number, provinceId: number, cityId: number, studentEntity?:Student, institutionEntity?:string){
    this.email = email;
    this.password = password;
    this.countryId = countryId;
    this.provinceId = provinceId;
    this.cityId = cityId;
    this.studentEntity = studentEntity;
    this.institutionEntity = institutionEntity;
    }
}