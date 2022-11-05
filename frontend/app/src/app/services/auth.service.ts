import { HttpClient, HttpHeaders } from '@angular/common/http';
import { EventEmitter, Injectable, Output } from '@angular/core';
import { Router } from '@angular/router';
import { CookieService } from 'ngx-cookie-service';
import { BehaviorSubject, catchError, map, Observable, throwError } from 'rxjs';
import { AuthenticationRequest } from '../models/AuthenticationRequest';
import { AuthenticationResponse } from '../models/AuthenticationResponse';

@Injectable({
  providedIn: 'root'
})
export class AuthService{

  private loggedIn =  new BehaviorSubject<boolean>(false);
  private student =  new BehaviorSubject<boolean>(false);
  private userName= new BehaviorSubject<string>('');
  private userId= new BehaviorSubject<number>(0);

  get isLoggedIn():Observable<boolean>{
    return this.loggedIn.asObservable();
  }
  get username():Observable<string>{
    return this.userName.asObservable();
  }
  get isUserStudent():Observable<boolean>{
    return this.student.asObservable();
  }
  get userIdNumber():Observable<number>{
    return this.userId.asObservable();
  }

  httpOptions = {
    headers: new HttpHeaders({
    }),
  };

  constructor(private http: HttpClient, private cookieService:CookieService, private route: Router) {}

  login(usuario: AuthenticationRequest): Observable<AuthenticationResponse> {
    return this.http
      .post<AuthenticationResponse>('http://localhost:8080/auth/login', usuario, this.httpOptions)
      .pipe(
        map((user : AuthenticationResponse) => {
          this.setToken(user.jwt);
          this.loggedIn.next(true);
          this.student.next(user.isStudent);
          this.userName.next(user.username);
          this.userId.next(user.id);
          return user;
        }),
        catchError((err) => this.handlerError(err))
      );

  }
  getToken(){
    // this.cookieService.get('auth_token');
    localStorage.getItem('auth_token');
  }
  setToken(token: string){
    // this.cookieService.set('auth_token', token);
    localStorage.setItem('auth_token', token);
  }
  logout():void{
    this.route.navigate(['/login']).then(()=>{
      localStorage.removeItem('auth_token');
      this.loggedIn.next(false);
      this.student.next(false);
    });
  }
  handlerError(err : any):Observable<never>{
    let errorMessage = 'An error occured retrieving data';
    if(err){
      errorMessage = `Error: code ${err.message}`;
    }
    window.alert('Datos incorrectos');
    return throwError(errorMessage);
  }

}
