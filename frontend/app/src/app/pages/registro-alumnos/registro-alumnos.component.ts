import { AuthService } from 'src/app/services/auth.service';
import { Student } from './../../models/Student';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { RegistroService } from 'src/app/services/registro.service';
import { User } from 'src/app/models/User';
import { catchError, pipe } from 'rxjs';

@Component({
  selector: 'app-registro-alumnos',
  templateUrl: './registro-alumnos.component.html',
  styleUrls: ['./registro-alumnos.component.css']
})
export class RegistroAlumnosComponent implements OnInit {

  constructor(private reg: RegistroService,private auth:AuthService, private router: Router) { }

  ngOnInit(): void {
  }

  registrado = false;

  datos = new FormGroup({
    name: new FormControl('', Validators.required),
    surname: new FormControl('', Validators.required),
    username: new FormControl('', Validators.required),
    date: new FormControl('', Validators.required),
    documentNumber: new FormControl('', Validators.required),
    provinceId: new FormControl('', Validators.required),
    cityId: new FormControl('', Validators.required),
    countryId: new FormControl('', Validators.required),
    password: new FormControl('', Validators.required),
    repassword: new FormControl('', Validators.required),
    check: new FormControl('',Validators.required)
  });

  onSubmit(){
    const userI = new User(
      this.datos.value['username'] as string,
      this.datos.value['password'] as string,
      this.datos.value['countryId'] as string,
      this.datos.value['provinceId'] as string,
      this.datos.value['cityId'] as string,
      true,
      false
    );
    const student = new Student(
      this.datos.value['name'] as string,
      this.datos.value['surname'] as string,
      this.datos.value['documentNumber'] as string,
      this.datos.value['date'] as string,
      userI
    );

    if(!this.datos.value['cityId'] || !this.datos.value['provinceId'] || !this.datos.value['countryId'] || !this.datos.value['username'] || !this.datos.value['password'] || !this.datos.value['repassword'] || !this.datos.value['name'] || !this.datos.value['surname'] || !this.datos.value['date'] || !this.datos.value['documentNumber'] || !this.datos.value['check']){
      return alert("Debes completar todos los campos y aceptar nuestros términos.");
    }else{
      if(this.datos.value['password'] != this.datos.value['repassword']){
        return alert("Las contraseñas no coinciden");
      }else{
        return this.reg
                   .studentRegister(student)
                   .subscribe(() => {
                     this.registrado = true;
                     this.router.navigate(['/login']);
                     alert("Registro exitoso");
                   })
      }
    }
  }

}
