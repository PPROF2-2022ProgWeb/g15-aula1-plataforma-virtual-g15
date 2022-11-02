import { AuthService } from 'src/app/services/auth.service';
import { Router } from '@angular/router';
import { CookieService } from 'ngx-cookie-service';
import { ChangeDetectorRef, Component, EventEmitter, Input, Output } from '@angular/core';

@Component({
  selector: 'app-commerce-header',
  templateUrl: './commerce-header.component.html',
  styleUrls: ['./commerce-header.component.css']
})
export class CommerceHeaderComponent{

  @Output() newItemEvent = new EventEmitter<string>();


  estadoSesion: boolean = false;


  nombreUsuario?: string;

  constructor(private router: Router, private auth: AuthService) {
    this.auth.isLoggedIn.subscribe((estado) => {
      this.estadoSesion = estado;
    });
    this.auth.username.subscribe((userName) => {
      this.nombreUsuario = userName;
    });
    // this.nombreUsuario = this.auth.getUsername();
    // this.estadoSesion = this.estadoSesion;
   }
   ngOnInit(): void {

   }

  iniciarSesion(){
    this.router.navigate(['/login']);
  }
  cerrarSesion(){
    this.auth.logout();
  }

  changeLeng(palabra:string):void{
    this.newItemEvent.emit(palabra);
  }
}
