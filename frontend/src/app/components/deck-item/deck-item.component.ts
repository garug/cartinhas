import { DeckService } from './../../deck/deck.service';
import { Deck } from './../../deck/models/deck';
import { Component, OnInit, Input } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-deck-item',
  templateUrl: './deck-item.component.html',
  styleUrls: ['./deck-item.component.scss']
})
export class DeckItemComponent implements OnInit {
  @Input() deck: Deck;

  constructor(
    private deckService: DeckService,
    private router: Router
  ) {
  }

  ngOnInit() {

  }

  edit(deck: Deck) {
    this.deckService.callToEdit(deck);
  }
}
