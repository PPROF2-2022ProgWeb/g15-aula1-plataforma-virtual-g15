import { ActivatedRoute, ActivatedRouteSnapshot } from '@angular/router';
import { AppRoutingModule } from './../../app-routing.module';

import { Component, OnInit } from '@angular/core';


@Component({
  selector: 'app-precios',
  templateUrl: './precios.component.html',
  styleUrls: ['./precios.component.css']
})
export class PreciosComponent implements OnInit {

  cantidadAnual: number = 0;
  cantidadMensual: number = 0;

  constructor() {

  }

  ngOnInit(): void {
  }

  onClickAnual = () => {
  ++this.cantidadAnual;
  }


}
