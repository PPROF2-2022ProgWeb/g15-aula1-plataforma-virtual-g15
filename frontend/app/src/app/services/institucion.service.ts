import { Injectable } from '@angular/core';
import { Institution } from '../models/Institution';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class InstitucionService {
  private API_SERVER = "http://localhost:8080/institutions";
  private headers: HttpHeaders = new HttpHeaders({'Content-Type': 'application/json'});

  constructor(private httpClient: HttpClient) { }

    //llamado a los metodos

    public getInstitution(id:number): Observable<Institution>{
      debugger;
      return this.httpClient.get<Institution>(this.API_SERVER + '/' + id, {headers:this.headers}) ;
      
    }
    public getCourses(id:number): Observable<Institution>{
      debugger;
      return this.httpClient.get<Institution>(this.API_SERVER + '/' + id + '/courses', {headers:this.headers}) ;
      
    }
    public addInstitutionCourse(id:number): Observable<Institution>{
      return this.httpClient.post<Institution>(this.API_SERVER + '/' + id + '/courses',{headers:this.headers});
    }

    public addCourse(id:number, idCourse:number): Observable<Institution>{
      return this.httpClient.post<Institution>(this.API_SERVER + '/' + id + '/courses' + idCourse,{headers:this.headers});
    }

}
