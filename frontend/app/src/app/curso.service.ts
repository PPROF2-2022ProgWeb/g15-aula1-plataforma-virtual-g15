import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Course } from './models/Course';

@Injectable({
  providedIn: 'root'
})
export class CursoService {

  private baseURL = "http://localhost:8080/course/list";

  constructor(private httpClient:HttpClient) { }

  //Metoso para obtener cursos
  getListCourses():Observable<Course[]>{
    return this.httpClient.get<Course[]>(`${this.baseURL}`);
  }
}
