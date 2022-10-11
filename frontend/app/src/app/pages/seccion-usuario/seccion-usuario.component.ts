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
  visibilidadCurso:boolean = false;
  visibilidadCarrera:boolean = false;

  constructor() { }

  ngOnInit(): void {
  }
  mostrarCursos():void{
    if(this.visibilidadCurso === false){
      this.visibilidadCurso = true;
      this.btnCursos = "Ocultar cursos";
    }else{
      this.visibilidadCurso = false;
      this.btnCursos = "Ver cursos";
    }
  }
  mostrarCarreras():void{
    if(this.visibilidadCarrera === false){
      this.visibilidadCarrera = true;
      this.btnCarreras = "Ocultar carreras";
    }else{
      this.visibilidadCarrera = false;
      this.btnCarreras = "Ver carreras";
    }
  }


}
