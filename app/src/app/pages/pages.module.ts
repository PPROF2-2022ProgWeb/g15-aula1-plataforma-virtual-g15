import { RouterModule } from '@angular/router';
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { LoginComponent } from './login/login.component';
import { NosotrosComponent } from './nosotros/nosotros.component';
import { RegistroInstitucionesComponent } from './registro-instituciones/registro-instituciones.component';
import { RegistroAlumnosComponent } from './registro-alumnos/registro-alumnos.component';
import { RecuperarPassComponent } from './recuperar-pass/recuperar-pass.component';
import { PoliticaComponent } from './politica/politica.component';
import { Pagina404Component } from './pagina404/pagina404.component';
import { LayoutModule } from '../layout/layout.module';
import { PreciosComponent } from './precios/precios.component';
import { CheckoutComponent } from './checkout/checkout.component';
import { FormsModule } from '@angular/forms';



@NgModule({
  declarations: [
    LoginComponent,
    NosotrosComponent,
    RegistroInstitucionesComponent,
    RegistroAlumnosComponent,
    RecuperarPassComponent,
    PoliticaComponent,
    Pagina404Component,
    PreciosComponent,
    CheckoutComponent
  ],
  imports: [
    CommonModule,
    LayoutModule,
    RouterModule,
    FormsModule
  ],
  exports: [
    LoginComponent,
    NosotrosComponent,
    RegistroInstitucionesComponent,
    RegistroAlumnosComponent,
    RecuperarPassComponent,
    PoliticaComponent,
    Pagina404Component,
    PreciosComponent,
    CheckoutComponent
  ]
})
export class PagesModule { }
