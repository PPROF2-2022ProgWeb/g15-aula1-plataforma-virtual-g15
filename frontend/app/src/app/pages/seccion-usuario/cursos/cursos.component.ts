import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router'
import { Subscriber } from 'rxjs';
import { Course } from 'src/app/models/Course';
import { Student } from 'src/app/models/Student';
import { EstudiantesService } from 'src/app/services/estudiantes.service';
import { InstitutionService } from 'src/app/services/institution.service';
import { environment } from 'src/environments/environment';
import { AuthService } from '../../../services/auth.service'

interface Cursos {
  id: number;
  nombre: string;
  descripcion: string;
  nivel?: string;
  fechaInicio: string;
  fechaFin: string;
  inscripto: boolean;
}
@Component({
  selector: 'app-cursos-alumnos',
  templateUrl: './cursos.component.html',
  styleUrls: ['./cursos.component.css']
})
export class CursosComponent implements OnInit {

  registrado: boolean = false;
  student: Student;
  courses: Course[]= [];

  constructor(private authService: AuthService, private service: EstudiantesService, private institucionService:InstitutionService) { }

  idUsuario = AuthService;
  idCourse: number;

  ngOnInit(): void {
    this.institucionService.getAllCourses().subscribe(courses=>{
      this.courses=courses;
    })
  }

  inscribirse(id: number) {
    console.log(id);
    this.courses.filter(curso => curso.id === id)[0] 
   
    alert('inscripcion exitosa')
  }
  eliminar(id: number) {
    console.log(id);
    this.courses.filter(curso => curso.id === id)[0]
    this.registrado = false
    alert("inscripcion eliminada!");
  }
}
