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

  institutionRegister(inst : Institution): Observable<Institution> {
    return this.http.post<Institution>('http://localhost:8080/auth/institution/register', inst, this.httpOptions);
  }
  studentRegister(stu : Student): Observable<Student> {
    return this.http.post<Student>('http://localhost:8080/auth/student/register', stu, this.httpOptions);
  }
}
