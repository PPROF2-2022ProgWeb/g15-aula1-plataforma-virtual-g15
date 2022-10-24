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
   }
   ngOnInit(): void {
    //Called after the constructor, initializing input properties, and the first call to ngOnChanges.
    //Add 'implements OnInit' to the class.
    this.auth.getEmitter().subscribe((estado) => {
      this.estadoSesion = estado;
    });
    this.auth.getEmitter2().subscribe((userName) => {
      this.nombreUsuario = userName;
    });

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
