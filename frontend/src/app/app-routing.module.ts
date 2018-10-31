import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { HomeComponent } from './home/home.component';
import { PageNotFoundComponent } from './page-not-found/page-not-found.component';
import { CadastrarDeck } from './deck/cadastrar/cadastrar-deck.component';

const routes: Routes = [
  {path: '', component: HomeComponent},//rota default
  {path: 'deck', component: CadastrarDeck},
  { path: '**', component: PageNotFoundComponent },//pagina que n esteja na rota
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
