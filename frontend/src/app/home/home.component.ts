import { Component, OnInit } from '@angular/core';
import { trigger, transition, style, animate, state, query, stagger, keyframes } from '@angular/animations';

import { DeckService } from '../deck/deck.service';
import { Deck } from './../deck/models/deck';

@Component({
  selector: 'app-home-component',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss'],
  animations: [
    trigger('animated', [
      transition('* => *', [
        query(':enter', [
          style({ transform: 'translateY(-20%)', opacity: 0 }),
          stagger(150, [
            animate('0.25s', keyframes([
              style({transform: 'translateY(-15%)',  opacity: .2 }),
              style({transform: 'translateY(-10%)',  opacity: .5 }),
              style({transform: 'translateY(0)',  opacity: 1 })
            ]))
          ])
        ], {optional: true})
      ])
    ])
  ]
})
export class HomeComponent implements OnInit {

  listDecks: Array<Deck>;

  constructor(private deckService: DeckService) { }

  ngOnInit() {
    this.getDecks();
  }

  getDecks() {
    this.deckService.getDecks().subscribe(response => this.listDecks = response);
  }

  teste(i) {
    console.log(i);
  }
}
