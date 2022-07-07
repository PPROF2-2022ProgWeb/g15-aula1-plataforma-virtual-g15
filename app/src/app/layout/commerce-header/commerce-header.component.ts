import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-commerce-header',
  templateUrl: './commerce-header.component.html',
  styleUrls: ['./commerce-header.component.css']
})
export class CommerceHeaderComponent implements OnInit {

  constructor() { }

  ngOnInit(): void {
  }
  estadoSesion: boolean = false;

  nombreUsuario: string = '#NOMBREUSARIO';

  iniciarSesion(){
    alert("redirecciona al login pero simulamos como quedarian los botones recien presionados");
    this.estadoSesion = true;
  }
}
