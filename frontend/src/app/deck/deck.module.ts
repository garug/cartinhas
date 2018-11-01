import { ComponentsModule } from './../components/components.module';
import { DeckRoutingModule } from './deck-routing.module';
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { DeckService } from './deck.service';

import { CadastrarDeckComponent } from './cadastrar/cadastrar-deck.component';
import { ViewDeckComponent } from './view-deck/view-deck.component';
import { FormsModule } from '@angular/forms';

@NgModule({
    declarations: [CadastrarDeckComponent, ViewDeckComponent],
    imports: [
        CommonModule,
        ComponentsModule,
        DeckRoutingModule,
        FormsModule
    ],
    exports: [],
    providers: [DeckService],
})

export class DeckModule { }
