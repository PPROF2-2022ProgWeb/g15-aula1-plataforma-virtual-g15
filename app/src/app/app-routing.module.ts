import { CheckoutComponent } from './pages/checkout/checkout.component';
import { PreciosComponent } from './pages/precios/precios.component';
import { Pagina404Component } from './pages/pagina404/pagina404.component';
import { RegistroInstitucionesComponent } from './pages/registro-instituciones/registro-instituciones.component';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './pages/login/login.component';
import { NosotrosComponent } from './pages/nosotros/nosotros.component';
import { RegistroAlumnosComponent } from './pages/registro-alumnos/registro-alumnos.component';


const routes: Routes = [
  { path: '', redirectTo: '/login', pathMatch: 'full' },
  { path: 'login', component: LoginComponent},
  { path: 'nosotros', component: NosotrosComponent},
  { path: 'registro-instituciones', component: RegistroInstitucionesComponent},
  { path: 'registro-alumnos', component: RegistroAlumnosComponent},
  { path: 'precios', component: PreciosComponent},
  { path: 'checkout', component: CheckoutComponent},
  { path: '**', component: Pagina404Component }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
