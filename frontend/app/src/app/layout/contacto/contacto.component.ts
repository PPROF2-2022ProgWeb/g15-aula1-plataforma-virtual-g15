import { Router } from '@angular/router';
import { InstitutionService } from './../../services/institution.service';
import { CommerceHeaderComponent } from './../commerce-header/commerce-header.component';
import { Component, OnInit } from '@angular/core';
import { timeout, timer } from 'rxjs';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Course } from 'src/app/models/Course';
import { AuthService } from 'src/app/services/auth.service';


@Component({
  providers : [CommerceHeaderComponent],
  selector: 'app-contacto',
  templateUrl: './contacto.component.html',
  styleUrls: ['./contacto.component.css']
})
export class ContactoComponent implements OnInit {

  curso!:FormGroup;

  constructor(
    private comp: CommerceHeaderComponent,
    private auth: AuthService,
    private institutionService:InstitutionService
    ) {
      this.curso = new FormGroup({
        name: new FormControl('CURSO NUEVO', Validators.required),
        description: new FormControl('DETALLE', Validators.required),
        beginningDay: new FormControl('12/12/2020', Validators.required),
        endingDay: new FormControl('12/12/2022', Validators.required)
      });
  }

  ngOnInit(): void {
  }
  traerFuncion(){
    this.comp.estadoSesion = false;
  }
  crearCurso(){

    let name = this.curso.value.name;
    let description = this.curso.value.description;
    let beginningDay = this.curso.value.beginningDay;
    let endingDay = this.curso.value.endingDay;

    if (this.curso.invalid)
      return alert("Oye");

   const data = new Course(name,description,beginningDay,endingDay);

   this.institutionService.createCourse(data).subscribe((data)=>{
     console.log(data.name)
     console.log(data.description)
     console.log(data.beginningDay)
     console.log(data.endingDay)
  })

   return alert("CURSO CREADO");
  }
}
