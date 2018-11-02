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
  }

}
