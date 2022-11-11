import { Component, OnInit } from '@angular/core';
import { Course } from '../../../models/Course';
import { Student } from 'src/app/models/Student';
import { CursoService } from '../../../curso.service';

interface Cursos {
  nombre:string;
  descripcion:string;
  nivel?:string;
  fechaInicio:string;
  fechaFin:string;
  cantidadInscriptos:number;
}

@Component({
  selector: 'app-cursos-de-institucion',
  templateUrl: './cursos-de-institucion.component.html',
  styleUrls: ['./cursos-de-institucion.component.css']
})
export class CursosDeInstitucionComponent implements OnInit {

  arregloCursos: Course[] = [];
  cInscriptos = 0;
  constructor(private cursoService:CursoService) { }

  ngOnInit(): void {
    this.getCourses();
  }

  private getCourses(){
    this.cursoService.getListCourses().subscribe(dato=>{
      this.arregloCursos = dato;
    })
  }

  eliminar(){
    alert("registro eliminado");
  }
  crear(){
    alert("curso creado con éxito");
  }
}
