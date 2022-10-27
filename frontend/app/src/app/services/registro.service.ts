import { Student } from './../models/Student';
import { Institution } from './../models/Institution';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class RegistroService {

  httpOptions = {
    headers: new HttpHeaders({
    }),
  };
  constructor(private http: HttpClient) { }

  institutionRegister(inst : Institution): Observable<Institution>{
    const email = inst.userEntity.email;
    const isExist = this.http.get<Boolean>('http://localhost:8080/auth/email/' + email, this.httpOptions);
    if(isExist){
      alert("Email ya existente");
    }
    return this.http.post<Institution>('http://localhost:8080/auth/institution/register', inst, this.httpOptions);
  }
  studentRegister(stu : Student): Observable<Student> {
    const email = stu.userEntity.email;
    const isExist = this.http.get<Boolean>('http://localhost:8080/auth/email/' + email, this.httpOptions);
    if(isExist){
      alert("Email existente");
    }
    return this.http.post<Student>('http://localhost:8080/auth/student/register', stu, this.httpOptions);
  }
}
