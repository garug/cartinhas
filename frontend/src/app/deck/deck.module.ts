import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { DeckService } from './deck.service';

import { CadastrarDeck } from './cadastrar/cadastrar-deck.component';
import { ViewDeckComponent } from './view-deck/view-deck.component';

@NgModule({
    declarations: [CadastrarDeck, ViewDeckComponent],
    imports: [CommonModule],
    exports: [CadastrarDeck],
    providers: [DeckService],
})

export class DeckModule { }
