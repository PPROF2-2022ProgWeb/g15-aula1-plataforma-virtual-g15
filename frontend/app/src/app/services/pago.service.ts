import { Observable, } from 'rxjs';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Reference } from '../models/Reference';


@Injectable({
  providedIn: 'root'
})
export class PagoService {

  private API_SERVER = "http://localhost:8080";

  httpOptions = {
    headers: new HttpHeaders({
    }),
  };

  constructor(private http: HttpClient) { }

  buyProduct(reference:Reference):Observable<any>{
    return this.http.post<any>(this.API_SERVER+'/reference/new', reference, this.httpOptions);
  }
}
