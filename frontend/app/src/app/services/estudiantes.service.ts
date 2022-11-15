import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Student } from '../models/Student';

@Injectable({
  providedIn: 'root'
})
export class EstudiantesService {
  private API_SERVER = "http://localhost:8080/students";
  private headers: HttpHeaders = new HttpHeaders({'Content-Type': 'application/json'});

  constructor(private httpClient: HttpClient) { }

  //llamado a los metodos
  public getStudent(id:number): Observable<Student>{
    debugger;
    return this.httpClient.get<Student>(this.API_SERVER + '/', {headers:this.headers});
    
  }
  public getStudentCourses(id:number): Observable<Student>{
    return this.httpClient.get<Student>(this.API_SERVER + '/' + '/courses', {headers:this.headers});
  }
  public deleteStudent(id:number): Observable<Student>{
    return this.httpClient.delete<Student>(this.API_SERVER + '/', {headers:this.headers});
  }
 
  public putStudent(dto: Student): Observable<Student>{
    return this.httpClient.put<Student>(this.API_SERVER + '/'+ dto,{headers:this.headers});
  }
  public postStudent(id:number,Student:Student): Observable<Student>{
    return this.httpClient.post<Student>(this.API_SERVER + '/'+ id + Student,{headers:this.headers});
  }

  //localhost:8080/students/1/courses/2 
  public inscribirseStudentAndCourses(idStudent:number, idCourse:number): Observable<Student>{
    return this.httpClient.post<Student>(this.API_SERVER + '/' + idStudent + '/courses/' + idCourse,{headers:this.headers});
  }
  public deleteStudentAndCourses(idStudent:number, idCourse:number): Observable<Student>{
    return this.httpClient.delete<Student>(this.API_SERVER + '/' + idStudent +'/courses' + idCourse, {headers:this.headers});
  }
}
