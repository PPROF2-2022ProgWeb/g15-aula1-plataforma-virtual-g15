import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-seccion-usuario',
  templateUrl: './seccion-usuario.component.html',
  styleUrls: ['./seccion-usuario.component.css']
})
export class SeccionUsuarioComponent implements OnInit {
  nombreAlumno = "{{NombreAlumno}}";
  btnCursos = "Ver cursos";
  btnCarreras = "Ver carreras";

  constructor() { }

  ngOnInit(): void {
  }
  mostrarCursos(){
  let cursos= document.getElementById('cursos');
  if (cursos?.classList.contains('d-none')) {
    cursos?.classList.replace('d-none', 'd-block');
    this.btnCursos = "Ocultar cursos";
  }else{
    cursos?.classList.replace('d-block','d-none');
    this.btnCursos = "Ver cursos";
  }
  }
  mostrarCarreras(){
  let carreras= document.getElementById('carreras');
  if (carreras?.classList.contains('d-none')) {
    carreras?.classList.replace('d-none', 'd-block');
    this.btnCarreras = "Ocultar carreras";
  }else{
    carreras?.classList.replace('d-block','d-none');
    this.btnCarreras = "Ver carreras";
  }
  }


}
