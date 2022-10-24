import { HttpClient, HttpHeaders } from '@angular/common/http';
import { EventEmitter, Injectable, Output } from '@angular/core';
import { CookieService } from 'ngx-cookie-service';
import { BehaviorSubject, map, Observable } from 'rxjs';
import { AuthenticationRequest } from '../models/AuthenticationRequest';
import { AuthenticationResponse } from '../models/AuthenticationResponse';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  @Output() fireIsLoggedIn: EventEmitter<any> = new EventEmitter<any>(); 
  @Output() fireIsLogged: EventEmitter<any> = new EventEmitter<any>(); 

  private userSubject: BehaviorSubject<AuthenticationResponse>;
  public user: Observable<AuthenticationResponse>;
  private estado: boolean = false;
  private userName!:string;


  constructor(private http: HttpClient, private cookieService:CookieService) {

    this.userSubject = new BehaviorSubject<AuthenticationResponse>
    (
      JSON.parse((`${localStorage.getItem('auth_token')}`))
    );
    this.user = this.userSubject.asObservable();
   }
   public get userValue(): AuthenticationResponse {
    return this.userSubject.value;
  }
  httpOptions = {
    headers: new HttpHeaders({
    }),
  };

  login(usuario: AuthenticationRequest): Observable<AuthenticationResponse> {

    return this.http
      .post<AuthenticationResponse>('http://localhost:8080/auth/login', usuario, this.httpOptions)
      .pipe(
        map((user : AuthenticationResponse) => {
          let datos: AuthenticationResponse = {
            username: user.username,
            jwt: user.jwt,
          };
          this.userName=datos.username as string;
          localStorage.setItem('auth_token', datos.jwt);
          this.userSubject.next(datos);
          this.estado = true;
          this.fireIsLoggedIn.emit(this.estado);
          this.fireIsLogged.emit(this.userName);

          return datos;
        })
      );
  }
  getEmitter() { 
    return this.fireIsLoggedIn; 
  } 
  getEmitter2() { 
    return this.fireIsLogged; 
  } 
  getUsername() { 
    return this.userName; 
  } 
  getToken(){
    return localStorage.getItem('auth_token');
  }
  logout() {
    this.fireIsLoggedIn.emit(this.estado =false);
    this.fireIsLogged.emit(this.userName='Iniciar Sesión');
    localStorage.removeItem('auth_token');
    this.cookieService.delete('auth_token');
    this.userSubject.closed;
  }

}
