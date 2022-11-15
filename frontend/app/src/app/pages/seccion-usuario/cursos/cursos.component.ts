import { Component, OnInit } from '@angular/core';
import { Course } from 'src/app/models/Course';
import { Student } from 'src/app/models/Student';
import { EstudiantesService } from 'src/app/services/estudiantes.service';
import { AuthService } from '../../../services/auth.service'

@Component({
  selector: 'app-cursos-alumnos',
  templateUrl: './cursos.component.html',
  styleUrls: ['./cursos.component.css']
})
export class CursosComponent implements OnInit {

  registrado: boolean = false;
  student: Student;
  courses: Course[]= [];

  constructor(private estudiantesService: EstudiantesService) { }

  ngOnInit(): void {
    this.loadCourses();
  }

  loadCourses(){
    return this.estudiantesService.getAllCourses().subscribe(data=>{
      data.forEach((dato)=>{
        this.courses.push(dato);
      });
    })
  }

  inscribirse(id: number):void{
    this.estudiantesService.inscribeStudentCourse(id).subscribe();
    this.courses = this.courses.filter(curso => curso.id != id);
    alert('inscripcion exitosa')
  }

  eliminar(id: number) {
    console.log(id);
    this.courses = this.courses.filter(curso => curso.id != id);
    this.registrado = false;
    alert("inscripcion eliminada!");
  }
}
