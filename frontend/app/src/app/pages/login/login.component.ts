import { Router } from '@angular/router';
import { Component, EventEmitter, OnInit, Output } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { AuthService } from 'src/app/services/auth.service';
import { CookieService } from 'ngx-cookie-service';
import { AuthenticationRequest } from 'src/app/models/AuthenticationRequest';


@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  
  login!:FormGroup;
  
  constructor(
    private auth: AuthService,
    private router: Router,
    private cookieService : CookieService
    ) {}

  ngOnInit(): void {
    this.login = new FormGroup({
      username: new FormControl('', Validators.required),
      password: new FormControl('', Validators.required)
    });
  }

  error = '';

  onSubmit(){
    if (this.login.invalid) {
       return;
    }
    let usuario = this.login.value.username;
    let password = this.login.value.password;
    const data = new AuthenticationRequest(usuario,password);

    this.auth.login(data).subscribe((data)=>{
      this.cookieService.set('auth_token', data.jwt);
      alert("Bienvenido " + data.username);

      //
      //this.estado = true;
      //this.estadoEvent.emit(this.estado);
      //this.cookieService.set('estadoSesion', 'true');
      //
      if(data.isStudent){
        this.router.navigate(['/alumnos']);
      }else{
        this.router.navigate(['/instituciones']);
      }

    }, (e)=>{
      e = "Datos inválidos";
      alert(this.error = e);
      this.login.reset();
    })
  }

  logout(){
    console.log("Correcto");
    return this.auth.logout();
  }
  //TODO emitir evento de variable estado par q el app module se lo comunique al layout module y al header
  

  
    
  

}