import { RouterModule } from '@angular/router';
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { LoginComponent } from './login/login.component';
import { NosotrosComponent } from './nosotros/nosotros.component';
import { RegistroInstitucionesComponent } from './registro-instituciones/registro-instituciones.component';
import { RegistroAlumnosComponent } from './registro-alumnos/registro-alumnos.component';
import { Pagina404Component } from './pagina404/pagina404.component';
import { LayoutModule } from '../layout/layout.module';
import { PreciosComponent } from './precios/precios.component';
import { CheckoutComponent } from './checkout/checkout.component';
import { FormsModule,
  ReactiveFormsModule } from '@angular/forms';
import { SeccionUsuarioComponent } from './seccion-usuario/seccion-usuario.component';
import { CursosComponent } from './seccion-usuario/cursos/cursos.component';
import { CarrerasComponent } from './seccion-usuario/carreras/carreras.component';
import { SeccionInstitucionComponent } from './seccion-institucion/seccion-institucion.component';
import { CursosDeInstitucionComponent } from './seccion-institucion/cursos-de-institucion/cursos-de-institucion.component';
import { CarrerasDeInstitucionComponent } from './seccion-institucion/carreras-de-institucion/carreras-de-institucion.component';

import {HttpClientModule, HttpClient, HTTP_INTERCEPTORS} from '@angular/common/http';
import {TranslateModule, TranslateLoader} from '@ngx-translate/core';
import {TranslateHttpLoader} from '@ngx-translate/http-loader';
import { CookieService } from 'ngx-cookie-service';
import { JwtInterceptorInterceptor } from '../interceptor/jwt-interceptor.interceptor';

export function createTranslateLoader(http: HttpClient) {
  return new TranslateHttpLoader(http, './assets/i18n/', '.json');
}

@NgModule({
  declarations: [
    LoginComponent,
    NosotrosComponent,
    RegistroInstitucionesComponent,
    RegistroAlumnosComponent,
    Pagina404Component,
    PreciosComponent,
    CheckoutComponent,
    SeccionUsuarioComponent,
    CursosComponent,
    CarrerasComponent,
    SeccionInstitucionComponent,
    CursosDeInstitucionComponent,
    CarrerasDeInstitucionComponent
  ],
  imports: [
    CommonModule,
    LayoutModule,
    RouterModule,
    ReactiveFormsModule,
    FormsModule,
    HttpClientModule,
    TranslateModule.forRoot({
      loader: {
          provide: TranslateLoader,
          useFactory: (createTranslateLoader),
          deps: [HttpClient]
      }
    })
  ],
  providers: [
    {
      provide: HTTP_INTERCEPTORS,
      useClass: JwtInterceptorInterceptor,
      multi: true
    },
  CookieService],
  exports: [
    LoginComponent,
    NosotrosComponent,
    RegistroInstitucionesComponent,
    RegistroAlumnosComponent,
    //ReactiveFormsModule,
    Pagina404Component,
    PreciosComponent,
    CheckoutComponent
  ]
})
export class PagesModule {



}
