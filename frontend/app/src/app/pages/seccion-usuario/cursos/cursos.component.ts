import { Component, OnInit } from '@angular/core';

interface Cursos{
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

  constructor() { }

  ngOnInit(): void {
    this.ArregloCursos = [
      {nombre: 'CURSO UX', descripcion: 'asdasd', fechaInicio: '20/09/2020', fechaFin: '20/09/2022'},
      {nombre: 'CURSO UI', descripcion: 'asdasd', fechaInicio: '20/09/2020', fechaFin: '20/09/2022'},
      {nombre: 'CURSO Testing Manual', descripcion: 'asdasd', fechaInicio: '20/09/2020', fechaFin: '20/09/2022'},
    ]
  }
  inscribirse(){
    alert('Inscripcion realizada correctamente!');
  }
}
