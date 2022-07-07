import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-carreras-de-institucion',
  templateUrl: './carreras-de-institucion.component.html',
  styleUrls: ['./carreras-de-institucion.component.css']
})
export class CarrerasDeInstitucionComponent implements OnInit {

  constructor() { }

  ngOnInit(): void {
  }
  modificar(){
    alert("registro modificado");
  }
  eliminar(){
    alert("registro eliminado");
  }
  crear(){
    alert("curso creado con éxito");
  }
}
