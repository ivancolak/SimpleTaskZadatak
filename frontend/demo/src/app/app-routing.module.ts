import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AddNewPacijentPregledComponent } from './add-new-pacijent-pregled/add-new-pacijent-pregled.component';
import { AddNewPregledComponent } from './add-new-pregled/add-new-pregled.component';
import { ListaPregledaPacijentaComponent } from './lista-pregleda-pacijenta/lista-pregleda-pacijenta.component';
import { ListaPregledaComponent } from './lista-pregleda/lista-pregleda.component';
import { LoginComponent } from './login/login.component';
import { LogoutComponent } from './logout/logout.component';
import { PacijentComponent } from './pacijent/pacijent.component';
import { AuthGuardService } from './service/auth-guard.service';
import { Zubar, ZubarComponent } from './zubar/zubar.component';



const routes: Routes = [
  { path: '', component: ZubarComponent, canActivate: [AuthGuardService]},
  { path: 'login', component: LoginComponent },
  {
    path: 'logout',
    component: LogoutComponent,
    canActivate: [AuthGuardService],
  },
  {
    path: 'zubar',
    component: ZubarComponent,
    canActivate: [AuthGuardService],
  },
  {
    path: 'newPregled',
    component: AddNewPregledComponent,
    canActivate: [AuthGuardService],
  },
  {
    path: 'pregledi',
    component: ListaPregledaComponent,
    canActivate: [AuthGuardService],
  },
  {
    path: 'pacijent',
    component: PacijentComponent,
    canActivate: [AuthGuardService],
  },
  
  {
    path: 'newPregledPacijent',
    component: AddNewPacijentPregledComponent,
    canActivate: [AuthGuardService],
  },
  {
    path: 'preglediPacijent',
    component: ListaPregledaPacijentaComponent,
    canActivate: [AuthGuardService],
  },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
