import { Component, OnInit } from '@angular/core';

interface Carreras{
  nombre:string;
  descripcion:string;
  fechaInicio:string;
  fechaFin: string;
}

@Component({
  selector: 'app-carreras-alumnos',
  templateUrl: './carreras.component.html',
  styleUrls: ['./carreras.component.css']
})
export class CarrerasComponent implements OnInit {

  ArregloCarreras: Carreras[] = [];

  constructor() { }

  ngOnInit(): void {
    this.ArregloCarreras = [
      {nombre: 'Carrera UX', descripcion: 'asdasd', fechaInicio: '20/09/2020', fechaFin: '20/09/2022'},
      {nombre: 'UI Carrera', descripcion: 'asdasd', fechaInicio: '20/09/2020', fechaFin: '20/09/2022'},
      {nombre: 'Carrera Testing Manual', descripcion: 'asdasd', fechaInicio: '20/09/2020', fechaFin: '20/09/2022'},
    ]
  }
  inscribirse(){
    alert("Te inscribiste correctamente al curso!");
  }
}
