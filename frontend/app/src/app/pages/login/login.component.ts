import { Router } from '@angular/router';
import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { AuthService } from 'src/app/services/auth.service';
import { CookieService } from 'ngx-cookie-service';
import { AuthenticationRequest } from 'src/app/models/AuthenticationRequest';
import { environment } from 'src/environments/environment';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  login!:FormGroup;

  constructor(
    private auth: AuthService,
    private router: Router
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
      if(data.isAdmin){
        alert("Bienvenido Administrador"+ " " + data.username);
        environment.idUsuario = data.id;
        this.router.navigate(['/nosotros']);
      }else{
        alert("Bienvenido"+" " + data.username);
        environment.idUsuario = data.id;
        if(data.isStudent){
          this.router.navigate(['/alumnos']);
        }else{
          this.router.navigate(['/instituciones']);
        }
      }
    }, (e)=>{
      this.login.reset();
    })
  }

  logout(){
    console.log("Correcto");
    return this.auth.logout();
  }
}
