import { Component, OnInit } from '@angular/core';

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
  
  ArregloCursos: Cursos[] = [];
  cInscriptos = 0;
  constructor() { }

  ngOnInit(): void {
    this.ArregloCursos = [
      {nombre: 'MI CURSO UX', descripcion: 'asdasd', fechaInicio: '20/09/2020', fechaFin: '20/09/2022', cantidadInscriptos: this.cInscriptos},
      {nombre: 'MI CURSO UI', descripcion: 'asdasd', fechaInicio: '20/09/2020', fechaFin: '20/09/2022', cantidadInscriptos: this.cInscriptos},
      {nombre: 'MI CURSO Testing Manual', descripcion: 'asdasd', fechaInicio: '20/09/2020', fechaFin: '20/09/2022', cantidadInscriptos: this.cInscriptos}
    ]
  }
  eliminar(){
    alert("registro eliminado");
  }
  crear(){
    alert("curso creado con éxito");
  }
}
