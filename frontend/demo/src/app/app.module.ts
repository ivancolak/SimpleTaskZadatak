import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { LoginService } from './service/login.service';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HeaderComponent } from './header/header.component';
import { LogoutComponent } from './logout/logout.component';
import { HttpClientModule } from '@angular/common/http';
import { ZubarComponent } from './zubar/zubar.component';
import { AddNewPregledComponent } from './add-new-pregled/add-new-pregled.component';
import { ZubarService } from './service/zubar.service';
import { ListaPregledaComponent } from './lista-pregleda/lista-pregleda.component';
import { AddNewPacijentPregledComponent } from './add-new-pacijent-pregled/add-new-pacijent-pregled.component';
import { PacijentComponent } from './pacijent/pacijent.component';
import { ListaPregledaPacijentaComponent } from './lista-pregleda-pacijenta/lista-pregleda-pacijenta.component';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    HeaderComponent,
    LogoutComponent,
    HeaderComponent,
    ZubarComponent,
    AddNewPregledComponent,
    ListaPregledaComponent,
    AddNewPacijentPregledComponent,
    PacijentComponent,
    ListaPregledaPacijentaComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    ReactiveFormsModule
  ],
  providers: [ZubarService, LoginService, LoginComponent],
  bootstrap: [AppComponent]
})
export class AppModule { }
