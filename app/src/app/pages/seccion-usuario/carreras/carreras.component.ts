import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-carreras-alumnos',
  templateUrl: './carreras.component.html',
  styleUrls: ['./carreras.component.css']
})
export class CarrerasComponent implements OnInit {

  constructor() { }

  ngOnInit(): void {
  }
  inscribirse(){
    alert("Te inscribiste correctamente al curso!");
  }
}
