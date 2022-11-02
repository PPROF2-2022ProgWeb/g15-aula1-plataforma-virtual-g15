import { AuthService } from 'src/app/services/auth.service';
import { Injectable } from '@angular/core';
import { ActivatedRouteSnapshot, CanActivate, Router, RouterStateSnapshot, UrlTree } from '@angular/router';
import { map, Observable, take } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class UserGuardGuard implements CanActivate {

  constructor(private auth: AuthService, private router: Router){

  }

  canActivate(): Observable<boolean>{

    return this.auth.isLoggedIn.pipe(
      //tomamos el primer valor emitido por el observable
      take(1),
      map((isLogged:boolean)=>isLogged)
    );}

    canUserStudent(): Observable<boolean>{

      return this.auth.isUserStudent.pipe(
        //tomamos el primer valor emitido por el observable
        take(1),
        map((isStudent:boolean)=>!isStudent)
      );}

}
