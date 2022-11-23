import { Router } from '@angular/router';
import { InstitutionService } from './../../services/institution.service';
import { CommerceHeaderComponent } from './../commerce-header/commerce-header.component';
import { Component, OnInit } from '@angular/core';
import { timeout, timer } from 'rxjs';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Course } from 'src/app/models/Course';
import { AuthService } from 'src/app/services/auth.service';


@Component({
  providers : [CommerceHeaderComponent],
  selector: 'app-contacto',
  templateUrl: './contacto.component.html',
  styleUrls: ['./contacto.component.css']
})
export class ContactoComponent implements OnInit {

  constructor(private comp: CommerceHeaderComponent){}

  ngOnInit(): void {
  }
  traerFuncion(){
    this.comp.estadoSesion = false;
  }
}
