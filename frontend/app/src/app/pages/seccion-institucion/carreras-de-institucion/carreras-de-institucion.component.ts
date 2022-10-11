import { Component, OnInit } from '@angular/core';

interface Carreras{
  nombre:string;
  descripcion:string;
  fechaInicio:string;
  fechaFin:string;
  cantidadInscriptos:number;
}

@Component({
  selector: 'app-carreras-de-institucion',
  templateUrl: './carreras-de-institucion.component.html',
  styleUrls: ['./carreras-de-institucion.component.css']
})
export class CarrerasDeInstitucionComponent implements OnInit {

  ArregloCarreras: Carreras[] = [];
  cInscriptos = 0;
  constructor() { }

  ngOnInit(): void {

    this.ArregloCarreras = [
      {nombre: 'MI CARRERA UX', descripcion: 'asdasd', fechaInicio: '20/09/2020', fechaFin: '20/09/2022', cantidadInscriptos: this.cInscriptos},
      {nombre: 'MI CARRERA UI', descripcion: 'asdasd', fechaInicio: '20/09/2020', fechaFin: '20/09/2022', cantidadInscriptos: this.cInscriptos},
      {nombre: 'MI CARRERA Testing Manual', descripcion: 'asdasd', fechaInicio: '20/09/2020', fechaFin: '20/09/2022', cantidadInscriptos: this.cInscriptos}
    ]

  }
  eliminar(){
    alert("registro eliminado");
  }
  crear(){
    alert("curso creado con éxito");
  }
}
