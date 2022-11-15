import { Observable } from 'rxjs';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Course } from '../models/Course';
import { AuthService } from './auth.service';

@Injectable({
  providedIn: 'root'
})
export class CourseService {


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

   public getCourseById(id:number):Observable<Course>{
    return this.http.get<Course>(this.API_SERVER + '/course/' + id, this.httpOptions);
   }
}
