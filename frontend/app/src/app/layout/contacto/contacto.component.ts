import { CommerceHeaderComponent } from './../commerce-header/commerce-header.component';
import { Component, OnInit } from '@angular/core';
import { timeout, timer } from 'rxjs';


@Component({
  providers : [CommerceHeaderComponent],
  selector: 'app-contacto',
  templateUrl: './contacto.component.html',
  styleUrls: ['./contacto.component.css']
})
export class ContactoComponent implements OnInit {

  constructor(private comp: CommerceHeaderComponent) { }

  ngOnInit(): void {
  }
  traerFuncion(){
    this.comp.estadoSesion = false;
  }
  crearCurso(item: string):void{
    console.log('Item->', item);
  }
}
