import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Student } from '../models/Student';
import { Course } from '../models/Course';
import { AuthService } from './auth.service';

@Injectable({
  providedIn: 'root'
})
export class EstudiantesService {
  private API_SERVER = "http://localhost:8080";

  id:number = 0;

  httpOptions = {
    headers: new HttpHeaders({
    }),
  };

  constructor(private auth: AuthService,
    private http: HttpClient) {
    this.auth.userIdNumber.subscribe((number)=>{
      this.id = number;
    })
   }
  //llamado a los metodos
  public getStudent(id:number): Observable<Student>{
    debugger;
    return this.http.get<Student>(this.API_SERVER + '/students/', this.httpOptions);

  }

  public getAllCourses():Observable<Course[]>{
    return this.http.get<Course[]>(this.API_SERVER+'/course/all', this.httpOptions);
  }

  public getStudentCourses(): Observable<Course[]>{
    return this.http.get<Course[]>(this.API_SERVER + '/students/' + this.id + '/courses', this.httpOptions);
  }

  public deleteStudent(id:number): Observable<Student>{
    return this.http.delete<Student>(this.API_SERVER + '/students', this.httpOptions);
  }

  public putStudent(dto: Student): Observable<Student>{
    return this.http.put<Student>(this.API_SERVER + '/students'+ dto,this.httpOptions);
  }
  public postStudent(id:number,Student:Student): Observable<Student>{
    return this.http.post<Student>(this.API_SERVER + '/students'+ id + Student, this.httpOptions);
  }

  public inscribeStudentCourse(idCourse:number): Observable<any>{
    return this.http.post<any>(this.API_SERVER + '/students/'+ this.id + '/courses/' + idCourse, this.httpOptions);
  }
  public deleteInscription(idCourse:number): Observable<any>{
     return this.http.delete<any>(this.API_SERVER + '/students/' + this.id +'/courses/' + idCourse, this.httpOptions);
  }
}
