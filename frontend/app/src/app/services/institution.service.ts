import { HttpHeaders, HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, catchError, throwError as observableThrowError } from 'rxjs';
import { __param } from 'tslib';
import { Course } from '../models/Course';
import { AuthService } from './auth.service';

@Injectable({
  providedIn: 'root'
})
export class InstitutionService {

  httpOptions = {
    headers: new HttpHeaders({
    }),
  };
  id:number = 0;

  constructor(private auth: AuthService,private http: HttpClient) {
    this.auth.userIdNumber.subscribe((number)=>{
      this.id = number;
    })
   }

  createCourse(course: Course): Observable<Course>{
    return this.http
               .post<Course>('http://localhost:8080/institutions/'+ this.id +'/courses', course, this.httpOptions)
               .pipe(
                catchError((error) => this.handlerError(error))
               );
  }

  handlerError(err : any):Observable<never>{
    let errorMessage = 'An error occured retrieving data';
    if(err){
      errorMessage = `Error: code ${err.message}`;
    }
    window.alert('Ocurrio un error al crear el curso');
    return observableThrowError(errorMessage);
  }
}
