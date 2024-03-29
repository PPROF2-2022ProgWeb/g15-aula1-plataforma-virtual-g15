import { Component, OnInit } from '@angular/core';
import { AuthService } from 'src/app/services/auth.service';

@Component({
  selector: 'app-seccion-usuario',
  templateUrl: './seccion-usuario.component.html',
  styleUrls: ['./seccion-usuario.component.css']
})
export class SeccionUsuarioComponent implements OnInit {
  nombreAlumno?:string;

  btnCursos = "Ver cursos";
 // btnCarreras = "Ver carreras";
  visibilidadCurso:boolean = false;
//  visibilidadCarrera:boolean = false;

  constructor(private auth:AuthService) { }

  ngOnInit(): void {

    this.auth.username.subscribe((nombre) => {
      this.nombreAlumno = nombre.slice(0, nombre.indexOf("@"));
    });
  }
  mostrarCursos():void{
    if(!this.visibilidadCurso){
      this.visibilidadCurso = true;
      this.btnCursos = "Ocultar cursos";
    }else{
      this.visibilidadCurso = false;
      this.btnCursos = "Ver cursos";
    }
  }
  /*
  mostrarCarreras():void{
    if(this.visibilidadCarrera === false){
      this.visibilidadCarrera = true;
      this.btnCarreras = "Ocultar carreras";
    }else{
      this.visibilidadCarrera = false;
      this.btnCarreras = "Ver carreras";
    }
  }
*/

}
