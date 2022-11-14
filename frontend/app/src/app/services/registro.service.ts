import { Student } from './../models/Student';
import { Institution } from './../models/Institution';
import { HttpClient, HttpHeaders,  } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { catchError, Observable, throwError as observableThrowError } from 'rxjs';

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
    return this.http
               .post<Institution>('http://localhost:8080/auth/institution/register', inst, this.httpOptions)
               .pipe(
                  catchError((err) => this.handlerError(err))
               );
  }
  studentRegister(stu : Student): Observable<Student> {
    return this.http.post<Student>('http://localhost:8080/auth/student/register', stu, this.httpOptions)
                    .pipe(
                       catchError((err) => this.handlerError(err))
                    );
  }

  handlerError(err : any):Observable<never>{
    let errorMessage = 'An error occured retrieving data';
    if(err){
      errorMessage = `Error: code ${err.message}`;
    }
    window.alert('Email existente');
    return observableThrowError(errorMessage);
  }
}
