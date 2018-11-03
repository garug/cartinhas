import { Deck } from './../models/deck';
import { DeckService } from './../deck.service';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-view-deck',
  templateUrl: './view-deck.component.html',
  styleUrls: ['./view-deck.component.scss']
})
export class ViewDeckComponent implements OnInit {
  deck: Deck = new Deck();
  decks:Array<Deck>;

  constructor(
    private activatedRoute: ActivatedRoute,
    private deckService: DeckService
  ) { }

  ngOnInit() {
    this.activatedRoute.params.subscribe(p => {
      this.deckService.callDeck(p['id']).subscribe(d => {
        this.deck = new Deck(d);
        this.deckService.callCards(this.deck.cards);
      });
    });
/*
    this.activatedRoute.params.subscribe(p => {

      this.deckService.getDeck(p['id']).subscribe(
        response => this.deck = response
      );

    });

    this.deck.cards.forEach(c => {
      this.deckService.getCardAPI(c.idReference).subscribe(
        response => {
          this.deck.cards.forEach(card => {
            response['cards'].forEach(cardResponse => {
              if (cardResponse.id === card.idReference) {
                card.name = cardResponse.name;
              }
            });
          });
        })
    });*/
  }

}
