import { Student } from "./Student";

export class User {
    id?: number;
    email: string;
    password: string;
    deleted: boolean = false;
    // CAMBIAR ID SEGUN LOS REGISTROS CREADOS EN SUS PROPIAS TABLAS
    countryId: number = 7;
    provinceId: number = 6;
    cityId: number = 5;
    //
    studentEntity?: Student;
    institutionEntity?: string;
    constructor(email: string, password: string){
    this.email = email;
    this.password = password;
    this.deleted;
    this.countryId;
    this.provinceId;
    this.cityId;
    }
}