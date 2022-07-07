import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { HeaderComponent } from './header/header.component';
import { FooterComponent } from './footer/footer.component';
import { ContactoComponent } from './contacto/contacto.component';
import { Router, RouterModule, Routes } from '@angular/router';
import { MembresiaComponent } from './membresia/membresia.component';
import { CommerceHeaderComponent } from './commerce-header/commerce-header.component';



@NgModule({
  declarations: [
    HeaderComponent,
    FooterComponent,
    ContactoComponent,
    MembresiaComponent,
    CommerceHeaderComponent
  ],
  imports: [
    CommonModule,
    RouterModule
  ],
  exports: [
    HeaderComponent,
    FooterComponent,
    ContactoComponent,
    MembresiaComponent
  ],
})
export class LayoutModule { }
