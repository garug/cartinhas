import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { DeckModule } from './deck/deck.module';
import { CadastrarDeck } from './deck/cadastrar/cadastrar-deck.component';
import { HomeComponent } from './home/home.component';
import { DeckItemComponent } from './components/deck-item/deck-item.component';

import { HttpClientModule } from '@angular/common/http';

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    DeckItemComponent
  ],
  imports: [
    BrowserModule,
    DeckModule,
    AppRoutingModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
