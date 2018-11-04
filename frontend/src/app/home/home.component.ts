import { Component, OnInit } from '@angular/core';
import { DeckService } from '../deck/deck.service';

import { Deck } from './../deck/models/deck';

@Component({
  selector: 'app-home-component',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']
})
export class HomeComponent implements OnInit {

  listDecks: Array<any>;

  constructor(private deckService: DeckService) { }

  ngOnInit() {
    this.getDecks();
  }

  getDecks() {
     this.deckService.getDecks().subscribe(response =>  this.listDecks = response);
  }

}
