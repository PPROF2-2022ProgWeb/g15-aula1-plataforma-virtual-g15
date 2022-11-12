import { PagesModule } from './pages/pages.module';
import { LayoutModule } from './layout/layout.module';
import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { CookieService } from 'ngx-cookie-service';
import { HttpClientModule } from '@angular/common/http';
import { Subject } from 'rxjs';
import { EstudiantesService } from './services/estudiantes.service';
import { UserGuardGuard } from './guard/user-guard.guard';
import { StudentGuardGuard } from './guard/student-guard.guard';
import { AuthService } from './services/auth.service';

@NgModule({
  declarations: [
    AppComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    LayoutModule,
    PagesModule,
    HttpClientModule
  ],
  providers: [CookieService, EstudiantesService, UserGuardGuard, StudentGuardGuard, AuthService],
  bootstrap: [AppComponent]
})
export class AppModule {


}
