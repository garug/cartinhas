import { ComponentsModule } from './../components/components.module';
import { DeckRoutingModule } from './deck-routing.module';
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { DeckService } from './deck.service';

import { CadastrarDeck } from './cadastrar/cadastrar-deck.component';
import { ViewDeckComponent } from './view-deck/view-deck.component';
import { BarTypesComponent } from '../components/bar-types/bar-types.component';

@NgModule({
    declarations: [CadastrarDeck, ViewDeckComponent],
    imports: [
        CommonModule,
        ComponentsModule,
        DeckRoutingModule
    ],
    exports: [],
    providers: [DeckService],
})

export class DeckModule { }
