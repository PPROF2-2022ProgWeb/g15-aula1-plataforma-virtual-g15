import { AuthService } from 'src/app/services/auth.service';
import { Component, EventEmitter, OnInit, Output } from '@angular/core';


@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {
  estadoSesion = false;
  @Output() newItemEvent = new EventEmitter<string>();

  constructor(private auth: AuthService) {
    this.auth.isLoggedIn.subscribe((estado) => {
      this.estadoSesion = estado;
    });
  }

  ngOnInit(): void {
  }

  changeLeng(palabra:string):void{
    this.newItemEvent.emit(palabra);
  }
}
