import { Component, OnInit } from '@angular/core';
import { DeckService } from '../deck.service';
import { Router } from '@angular/router';
import { Deck } from '../../entity/deck';

@Component({
    selector: 'cadastrar-deck',
    templateUrl: './cadastrar-deck.component.html'
})

export class CadastrarDeck implements OnInit {

    deck:Deck;

    constructor(private deckService: DeckService,private router:Router) {
        this.deck = new Deck();
    }

    ngOnInit(): void { }

    salvar(){
        this.deckService.setDeck(this.deck).subscribe(
            response => this.router.navigate(['/'])
        );
    }
}
