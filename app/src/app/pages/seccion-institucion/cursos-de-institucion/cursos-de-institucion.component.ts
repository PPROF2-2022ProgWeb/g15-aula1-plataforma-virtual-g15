import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-cursos-de-institucion',
  templateUrl: './cursos-de-institucion.component.html',
  styleUrls: ['./cursos-de-institucion.component.css']
})
export class CursosDeInstitucionComponent implements OnInit {

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
