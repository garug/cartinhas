import { Component, OnInit } from '@angular/core';
import { DeckService } from '../deck.service';

@Component({
    selector: 'cadastrar-deck',
    templateUrl: './cadastrar-deck.component.html'
})

export class CadastrarDeck implements OnInit {
    constructor(private deckService: DeckService) { }

    ngOnInit(): void { }

}
