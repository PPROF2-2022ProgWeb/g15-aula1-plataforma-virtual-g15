import { Student } from "./Student";

export class User {
    id?: number;
    email: string;
    password: string;
    deleted: boolean = false;
    //TODO CAMBIAR ID SEGUN LOS REGISTROS CREADOS EN SUS PROPIAS TABLAS
    countryId: string;
    provinceId: string;
    cityId: string;
    //
    studentEntity?: Student;
    institutionEntity?: string;
    constructor(email: string, password: string, countryId: string, provinceId: string, cityId:string){
    this.email = email;
    this.password = password;
    this.deleted;
    this.countryId = countryId;
    this.provinceId = provinceId;
    this.cityId = cityId;
    }
}