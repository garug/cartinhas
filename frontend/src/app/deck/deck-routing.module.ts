import { ViewDeckComponent } from './view-deck/view-deck.component';
import { CadastrarDeck } from './cadastrar/cadastrar-deck.component';
import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

const routes: Routes = [
  {
    path: 'deck', children: [
      { path: '', component: CadastrarDeck},
      { path: ':id', component: ViewDeckComponent }
    ]
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class DeckRoutingModule { }
