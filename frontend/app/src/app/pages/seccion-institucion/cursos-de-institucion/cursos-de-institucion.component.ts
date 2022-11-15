import { Component, OnInit,  } from '@angular/core';
import { Course } from '../../../models/Course';
import { InstitutionService } from 'src/app/services/institution.service';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { CommerceHeaderComponent } from 'src/app/layout/commerce-header/commerce-header.component';
import { AuthService } from 'src/app/services/auth.service';

@Component({
  selector: 'app-cursos-de-institucion',
  templateUrl: './cursos-de-institucion.component.html',
  styleUrls: ['./cursos-de-institucion.component.css']
})
export class CursosDeInstitucionComponent implements OnInit {

  listCourse: Course[] = [];
  cInscriptos = 0;
  idCourse:number;

  constructor(private institutionService:InstitutionService){}

  ngOnInit(): void {
    this.loadCourses();
  }

  curso = new FormGroup({
    name: new FormControl('CURSO NUEVO', Validators.required),
    description: new FormControl('DETALLE', Validators.required),
    beginningDay: new FormControl('12-12-2020', Validators.required),
    endingDay: new FormControl('12/12/2022', Validators.required)
  });

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
    this.idCourse = id;
    this.institutionService.getCourses(id).subscribe((data)=>{
      this.curso.get('name').setValue(data.name);
      this.curso.get('description').setValue(data.description);
      this.curso.get('beginningDay').setValue(data.beginningDay);
      this.curso.get('endingDay').setValue(data.endingDay);
      })
  }
  editarCurso(){
    let name = this.curso.value.name;
    let description = this.curso.value.description;
    let beginningDay = this.curso.value.beginningDay;
    let endingDay = this.curso.value.endingDay;

    if (this.curso.invalid)
      return alert("faltan datos");

   const datos = new Course(name,description,beginningDay,endingDay);
   this.institutionService.editCourse(this.idCourse, datos)
   .subscribe((data)=>{
    console.log(data.id)
  });
   return alert("CURSO MODIFICADO");
  }


  crearCurso(){
    let name = this.curso.value.name;
    let description = this.curso.value.description;
    let beginningDay = this.curso.value.beginningDay;
    let endingDay = this.curso.value.endingDay;

    if (this.curso.invalid)
      return alert("faltan datos");

   const datos = new Course(name,description,beginningDay,endingDay);

  this.institutionService
  .createCourse(datos)
  .subscribe((data)=>{
    console.log(data.id)
  });
   return alert("CURSO CREADO");
  }
}
