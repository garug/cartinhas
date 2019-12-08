import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { HomeComponent } from './home/home.component';
import { PageNotFoundComponent } from './page-not-found/page-not-found.component';
import { CadastrarDeckComponent } from './deck/cadastrar/cadastrar-deck.component';
import { LoginComponent } from './login/login.component';

const routes: Routes = [
  // { path: '', component: HomeComponent }, // rota default
  { path: '', redirectTo: '/home', pathMatch: 'full' },//rota default
  { path: 'home', component: HomeComponent },
  { path: 'login', component: LoginComponent },
  // { path: '**', component: PageNotFoundComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
