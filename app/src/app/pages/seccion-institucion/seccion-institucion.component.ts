import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-seccion-institucion',
  templateUrl: './seccion-institucion.component.html',
  styleUrls: ['./seccion-institucion.component.css']
})
export class SeccionInstitucionComponent implements OnInit {
  nombreInstitucion = "{{NombreInstitucion}}";
  btnCursos = "Ver mis Cursos";
  btnCarreras = "Ver mis carreras";
  constructor() { }

  ngOnInit(): void {
  }
  mostrarCursos(){
    let cursos= document.getElementById('cursosI');
    if (cursos?.classList.contains('d-none')) {
      cursos?.classList.replace('d-none', 'd-block');
      this.btnCursos = "Ocultar mis cursos";
    }else{
      cursos?.classList.replace('d-block','d-none');
      this.btnCursos = "Ver mis cursos"
    }
    }
  mostrarCarreras(){
    let carreras= document.getElementById('carrerasI');
    if (carreras?.classList.contains('d-none')) {
      carreras?.classList.replace('d-none', 'd-block');
      this.btnCarreras = "Ocultar mis carreras";
    }else{
      carreras?.classList.replace('d-block','d-none');
      this.btnCarreras = "Ver mis cursos";
    }
    }

}
