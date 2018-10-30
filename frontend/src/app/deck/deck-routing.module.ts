import { ViewDeckComponent } from './view-deck/view-deck.component';
import { CadastrarDeck } from './cadastrar/cadastrar-deck.component';
import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

const routes: Routes = [
  {path: 'deck', component: CadastrarDeck},
  {path: 'deck/:id', component: ViewDeckComponent}
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class DeckRoutingModule { }
