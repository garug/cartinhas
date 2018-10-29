import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { DeckService } from './deck.service';

import { CadastrarDeck } from './cadastrar/cadastrar-deck.component';

@NgModule({
    declarations: [CadastrarDeck],
    imports: [CommonModule],
    exports: [CadastrarDeck],
    providers: [DeckService],
})

export class DeckModule { }