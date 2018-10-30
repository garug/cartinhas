import { Deck } from './../../deck/models/deck';
import { Component, OnInit, Input } from '@angular/core';

@Component({
  selector: 'app-deck-item',
  templateUrl: './deck-item.component.html',
  styleUrls: ['./deck-item.component.scss']
})
export class DeckItemComponent implements OnInit {
  @Input() deck: Deck;

  constructor() {
  }

  ngOnInit() {

  }

  hasColor(color: string) {
    return this.deck.types.find(e => e === color);
  }

}
