import { Institution } from './../../models/Institution';
import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { User } from 'src/app/models/User';
import { Router } from '@angular/router';
import { RegistroService } from 'src/app/services/registro.service';

@Component({
  selector: 'app-registro-instituciones',
  templateUrl: './registro-instituciones.component.html',
  styleUrls: ['./registro-instituciones.component.css']
})
export class RegistroInstitucionesComponent implements OnInit {

  constructor(private reg: RegistroService, private router: Router) { }

  ngOnInit(): void {
  }

  registrado = false;

  datos = new FormGroup({
    name: new FormControl('', Validators.required),
    username: new FormControl('', Validators.required),
    cuitNumber: new FormControl('', Validators.required),
    provinceId: new FormControl('', Validators.required),
    cityId: new FormControl('', Validators.required),
    countryId: new FormControl('', Validators.required),
    password: new FormControl('', Validators.required),
    repassword: new FormControl('', Validators.required),
    check: new FormControl(Validators.required)
  });

  onSubmit() {
    const userI = new User(
      this.datos.value['username'] as string,
      this.datos.value['password'] as string,
      this.datos.value['countryId'] as string,
      this.datos.value['provinceId'] as string,
      this.datos.value['cityId'] as string,
      false
    );
    const institution = new Institution(
      this.datos.value['name'] as string,
      this.datos.value['cuitNumber'] as string,
      userI
    );

    if(!this.datos.value['cityId'] || !this.datos.value['provinceId'] || !this.datos.value['countryId'] || !this.datos.value['username'] || !this.datos.value['password'] || !this.datos.value['repassword'] || !this.datos.value['name'] || !this.datos.value['cuitNumber'] || !this.datos.value['check']){
      return alert("Debes completar todos los campos y aceptar nuestros términos.");
    }else{
      if(this.datos.value['password'] != this.datos.value['repassword']){
        return alert("Las contraseñas no coinciden");
      }else{
        return this.reg.institutionRegister(institution).subscribe(inst => {
          console.log(inst);
          this.registrado = true;
          if(!this.registrado){
            alert("Intenta de nuevo");
          }else{
            this.router.navigate(['/login']);
            alert("Registro exitoso");
          }
        });
      }
    }
  }
}
