import { ViewDeckComponent } from './view-deck/view-deck.component';
import { CadastrarDeckComponent } from './cadastrar/cadastrar-deck.component';
import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

const routes: Routes = [
  {
    path: 'deck', children: [
      { path: '', component: CadastrarDeckComponent},
      { path: ':id', component: ViewDeckComponent }
    ]
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class DeckRoutingModule { }
