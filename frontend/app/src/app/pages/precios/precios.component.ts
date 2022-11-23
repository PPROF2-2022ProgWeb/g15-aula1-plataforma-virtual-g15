import { __param } from 'tslib';
import { Item } from './../../models/Item';

import { Component, OnInit } from '@angular/core';
import { Reference } from 'src/app/models/Reference';
import { PagoService } from 'src/app/services/pago.service';


@Component({
  selector: 'app-precios',
  templateUrl: './precios.component.html',
  styleUrls: ['./precios.component.css']
})
export class PreciosComponent implements OnInit {

  cantidadAnual: number = 0;
  cantidadMensual: number = 0;
  ACCESS_TOKEN:string =  "TEST-5462318479570379-070117-08e69a4d80f8ece3cd527a3810ee7291-114387581";
  lista: Item[] = [];

  constructor(private pagoService: PagoService) {

  }

  ngOnInit(): void {
  }

  onClickAnual = () => {
  ++this.cantidadAnual;
  }

  pagar(){
    let item  = new Item("Membresia","Abono mensual",1200.00,1);
    this.lista.push(item);
    let reference = new Reference(this.ACCESS_TOKEN,this.lista);
    return this.pagoService.buyProduct(reference).subscribe((datos)=>{
      window.open(datos['initPoint'], '_blank');
    });
  }

}
