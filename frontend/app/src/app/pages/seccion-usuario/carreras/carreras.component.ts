import { Component, OnInit } from '@angular/core';
import { environment } from 'src/environments/environment';
import{AuthService} from '../../../services/auth.service';
import{Institution} from '../../../models/Institution';

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

 //alba: este el codigo para los servicios - hay que pasar en el html la variable del id de la carrera
 //  institution: Institution;
  //constructor(private authService: AuthService, private service:InstitucionService) { }
constructor(){}

  ngOnInit(): void {
    this.ArregloCarreras = [
      { nombre: 'Carrera UX', descripcion: 'asdasd', fechaInicio: '20/09/2020', fechaFin: '20/09/2022'},
      { nombre: 'UI Carrera', descripcion: 'asdasd', fechaInicio: '20/09/2020', fechaFin: '20/09/2022'},
      { nombre: 'Carrera Testing Manual', descripcion: 'asdasd', fechaInicio: '20/09/2020', fechaFin: '20/09/2022'},
    ]
  }


  inscribirse(){
    alert("Te inscribiste correctamente al curso!");
  }

 /*
  console.log(idCarreras);
   this.service.inscribirseStudentAndCourses(idCarreras,environment.idUsuario).subscribe(response =>{console.log(response)});
  }
  */

}
