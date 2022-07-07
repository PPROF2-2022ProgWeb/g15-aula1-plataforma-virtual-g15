import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-cursos-alumnos',
  templateUrl: './cursos.component.html',
  styleUrls: ['./cursos.component.css']
})
export class CursosComponent implements OnInit {

  constructor() { }

  ngOnInit(): void {
  }
  inscribirse(){
    alert('Inscripcion realizada correctamente!');
  }
}
