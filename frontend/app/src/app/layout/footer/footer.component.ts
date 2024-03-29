import { Component, OnInit } from '@angular/core';
import { AuthService } from 'src/app/services/auth.service';

@Component({
  selector: 'app-footer',
  templateUrl: './footer.component.html',
  styleUrls: ['./footer.component.css']
})
export class FooterComponent implements OnInit {

  estadoSesion = false;

  constructor(private auth: AuthService) {
    this.auth.isLoggedIn.subscribe((estado) => {
      this.estadoSesion = estado;
    });
   }

  ngOnInit(): void {

  }

}
