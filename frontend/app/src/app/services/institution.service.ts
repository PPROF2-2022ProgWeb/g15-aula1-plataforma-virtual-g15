import { HttpHeaders, HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, catchError, throwError as observableThrowError } from 'rxjs';
import { Course } from '../models/Course';
import { Institution } from '../models/Institution';
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
  public coursesId: Course[] = [];
  private API_SERVER = "http://localhost:8080";

  constructor(private auth: AuthService,
    private http: HttpClient) {
    this.auth.userIdNumber.subscribe((number)=>{
      this.id = number;
    })
   }

  public createCourse(course: Course): Observable<Course>{
    return this.http
               .post<Course>(this.API_SERVER +'/institutions/'+ this.id +'/courses', course, this.httpOptions)
               .pipe(
                catchError((error) => this.handlerError(error))
               );
  }
  public deleteCourse(id:number): Observable<void>{
    return this.http
               .delete<void>(this.API_SERVER + '/course/' + id, this.httpOptions);
  }

  public getAllCoursesById(): Observable<Course[]>{
    return this.http
               .get<Course[]>(this.API_SERVER +'/course/all/'+ this.id, this.httpOptions)
               .pipe(
                catchError((error) => this.handlerError(error))
               );
  }

  public getInstitution(id:number): Observable<Institution>{
    return this.http.get<Institution>(this.API_SERVER + '/institutions/' + this.id, this.httpOptions) ;
  }

  public getCourses(id:number): Observable<Course>{
    return this.http.get<Course>(this.API_SERVER + '/course/' + this.id, this.httpOptions) ;
  }

  public handlerError(err : any):Observable<never>{
    let errorMessage = 'An error occured retrieving data';
    if(err){
      errorMessage = `Error: code ${err.message}`;
    }
    window.alert('Ocurrio un error.');
    return observableThrowError(errorMessage);
  }
}
