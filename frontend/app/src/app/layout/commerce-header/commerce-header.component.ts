import { Component, EventEmitter, Output } from '@angular/core';

@Component({
  selector: 'app-commerce-header',
  templateUrl: './commerce-header.component.html',
  styleUrls: ['./commerce-header.component.css']
})
export class CommerceHeaderComponent{

  @Output() newItemEvent = new EventEmitter<string>();

  estadoSesion: boolean = false;

  nombreUsuario: string = '#NOMBREUSARIO';

  constructor() { }

  iniciarSesion(){
    alert("redirecciona al login pero simulamos como quedarian los botones recien presionados");
    this.estadoSesion = true;
  }
  changeLeng(idioma:string):void{
    this.newItemEvent.emit(idioma);
  }
}
