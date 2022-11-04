import { Component, OnInit } from '@angular/core';
import {Router} from '@angular/router'
import { Subscriber } from 'rxjs';
import { Student } from 'src/app/models/Student';
import { EstudiantesService } from 'src/app/services/estudiantes.service';
import { environment } from 'src/environments/environment';
import{AuthService} from '../../../services/auth.service'

interface Cursos{
  id:number;
  nombre:string;
  descripcion:string;
  nivel?: string;
  fechaInicio:string;
  fechaFin: string;
}
@Component({
  selector: 'app-cursos-alumnos',
  templateUrl: './cursos.component.html',
  styleUrls: ['./cursos.component.css']
})
export class CursosComponent implements OnInit {

  ArregloCursos: Cursos[] = [];
  
  //cree las variables - alba
  registrado:boolean = false;
  student: Student;

  //alba agregue en el constructor
  constructor(private authService: AuthService, private service: EstudiantesService) { }

  ngOnInit(): void {
    this.ArregloCursos = [
      {id:1,nombre: 'CURSO UX', descripcion: 'asdasd', fechaInicio: '20/09/2020', fechaFin: '20/09/2022'},
      {id:2,nombre: 'CURSO UI', descripcion: 'asdasd', fechaInicio: '20/09/2020', fechaFin: '20/09/2022'},
      {id:3,nombre: 'CURSO Testing Manual', descripcion: 'asdasd', fechaInicio: '20/09/2020', fechaFin: '20/09/2022'},
    ]
  }
  /*
  inscribirse(){
    alert('Inscripcion realizada correctamente!');
  }
  */

  //Alba

  inscribirse(idCourse:number) {
   console.log(idCourse);
   this.service.inscribirseStudentAndCourses(idCourse,environment.idUsuario).subscribe(response =>{console.log(response)});
   this.registrado=true;
  }
   
}
