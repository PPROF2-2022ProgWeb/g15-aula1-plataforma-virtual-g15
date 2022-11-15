import { CookieService } from 'ngx-cookie-service';
import { CourseService } from './../../../services/course.service';
import { Component, OnInit } from '@angular/core';
import { Course } from 'src/app/models/Course';
import { Student } from 'src/app/models/Student';
import { EstudiantesService } from 'src/app/services/estudiantes.service';

@Component({
  selector: 'app-cursos-alumnos',
  templateUrl: './cursos.component.html',
  styleUrls: ['./cursos.component.css']
})
export class CursosComponent implements OnInit {

  registrado: boolean = false;
  student: Student;
  courses: Course[]= [];
  inscripciones: Course[]= [];
  contadorInscripcion = 0;
  existsInscriptions: boolean = this.cookieService.check('contadorInscripcion');

  constructor(private estudiantesService: EstudiantesService, private courseService:CourseService, private cookieService:CookieService) { }

  ngOnInit(): void {

    this.loadCourses();

    this.loadInscripciones();

  }

  loadCourses(){
    return this.estudiantesService.getAllCourses().subscribe(data=>{
      data.forEach((dato)=>{
        this.courses.push(dato);
      });
    })
  }

  loadInscripciones(){
    return this.estudiantesService.getStudentCourses().subscribe((data)=>{
      data.forEach((dato)=>{
        this.inscripciones.push(dato);
      })
    });
  }

  inscribirse(id: number):void{
    this.estudiantesService.inscribeStudentCourse(id).subscribe();
    this.courses = this.courses.filter(curso => curso.id != id);
    this.contadorInscripcion++;
    this.courseService.getCourseById(id).subscribe((dato)=>{
      this.inscripciones.push(dato);
    })
    this.cookieService.set('contadorInscripcion', this.contadorInscripcion.toString());
    return alert('inscripcion exitosa');
  }

  eliminar(id: number) {
    this.inscripciones = this.inscripciones.filter(curso => curso.id != id);
    this.registrado = false;
    this.courseService.getCourseById(id).subscribe((dato)=>{
      this.courses.push(dato);
    })
    this.estudiantesService.deleteInscription(id).subscribe();
    this.contadorInscripcion--;
    this.cookieService.set('contadorInscripcion', this.contadorInscripcion.toString());

    if(this.contadorInscripcion==0){
      this.cookieService.delete('contadorInscripcion');
    }

    alert("inscripcion eliminada!");
  }
}
