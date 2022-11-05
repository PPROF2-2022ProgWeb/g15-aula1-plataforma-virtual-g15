import { AuthService } from 'src/app/services/auth.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-seccion-institucion',
  templateUrl: './seccion-institucion.component.html',
  styleUrls: ['./seccion-institucion.component.css']
})
export class SeccionInstitucionComponent implements OnInit {
  nombreInstitucion?:string;

  btnCursos = "Ver mis Cursos";
 // btnCarreras = "Ver mis carreras";
  visibilidadCurso:boolean = false;
//  visibilidadCarrera:boolean = false;

  constructor(private auth:AuthService) {
   }

  ngOnInit(): void {
    this.auth.username.subscribe((nombre) => {
      this.nombreInstitucion = nombre.slice(0, nombre.indexOf("@"));
    });
  }
  mostrarCursos():void{
    if(this.visibilidadCurso === false){
      this.visibilidadCurso = true;
      this.btnCursos = "Ocultar mis cursos";
    }else{
      this.visibilidadCurso = false;
      this.btnCursos = "Ver mis cursos";
    }
  }
  /*
  mostrarCarreras():void{
    if(this.visibilidadCarrera === false){
      this.visibilidadCarrera = true;
      this.btnCarreras = "Ocultar mis carreras";
    }else{
      this.visibilidadCarrera = false;
      this.btnCarreras = "Ver mis carreras";
    }
  }
*/
}
