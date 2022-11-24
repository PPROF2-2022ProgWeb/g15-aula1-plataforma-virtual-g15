import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Course } from '../models/Course';
import { AuthService } from 'src/app/services/auth.service';

@Injectable({
  providedIn: 'root'
})
export class CursoService {

  private baseURL = "http://localhost:8080/course/list";

  constructor(private httpClient:HttpClient) { }

  //Obtener cursos
  getListCourses():Observable<Course[]>{
    return this.httpClient.get<Course[]>(`${this.baseURL}`);
  }

  //Crear curso institucion
  saveCourse(course:Course) : Observable<Object>{
    return this.httpClient.post(`${this.baseURL}`, course)
  }

  //Eliminar Curso
  deleteCourse(id:any) : Observable<Object>{
  return this.httpClient.delete(`${this.baseURL}`, id)
  }


}
