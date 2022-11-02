import { AuthService } from 'src/app/services/auth.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-nosotros',
  templateUrl: './nosotros.component.html',
  styleUrls: ['./nosotros.component.css']
})
export class NosotrosComponent implements OnInit {

  estadoSesion = false;

  constructor(private auth: AuthService) {
    this.auth.isLoggedIn.subscribe((estado) => {
      this.estadoSesion = estado;
    });
  }

  ngOnInit(): void {
  }

}
