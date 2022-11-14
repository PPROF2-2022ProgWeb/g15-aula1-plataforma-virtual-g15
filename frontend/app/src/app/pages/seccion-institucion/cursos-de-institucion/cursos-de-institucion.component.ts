import { Observable } from 'rxjs';
import { ChangeDetectorRef, Component, OnInit, SimpleChanges } from '@angular/core';
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

  eliminar(){
    alert("registro eliminado");
  }
  crear(){
    alert("curso creado con éxito");
  }
}
