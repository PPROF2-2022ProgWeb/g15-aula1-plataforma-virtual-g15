import { Component, OnInit,  } from '@angular/core';
import { Course } from '../../../models/Course';
import { InstitutionService } from 'src/app/services/institution.service';

@Component({
  selector: 'app-cursos-de-institucion',
  templateUrl: './cursos-de-institucion.component.html',
  styleUrls: ['./cursos-de-institucion.component.css']
})
export class CursosDeInstitucionComponent implements OnInit {

  listCourse: Course[] = [];
  cInscriptos = 0;
  constructor(private institutionService:InstitutionService) { }

  ngOnInit(): void {
    this.loadCourses();
  }

  loadCourses(){
    return this.institutionService.getAllCoursesById().subscribe(data=>{
      data.forEach((dato)=>{
        this.listCourse.push(dato);
      });
    })
  }

  eliminar(id:number):void{
    this.institutionService.deleteCourse(id).subscribe();
    this.listCourse = this.listCourse.filter(c=>c.id != id);
    alert("Curso eliminado correctamente!");
  }
  editar(id:number){
    alert("curso creado con éxito");
  }
}
