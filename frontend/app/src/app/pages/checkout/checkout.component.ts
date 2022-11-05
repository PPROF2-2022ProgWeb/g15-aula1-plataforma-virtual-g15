
import { Component, Input, OnInit } from '@angular/core';

@Component({
  selector: 'app-checkout',
  templateUrl: './checkout.component.html',
  styleUrls: ['./checkout.component.css']
})




export class CheckoutComponent implements OnInit {


  cAnual: number = 0;
  cMensual: number = 0;

  constructor() { }

  ngOnInit(): void {

  }

}
