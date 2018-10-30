import { DeckService } from './../deck/deck.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-home-component',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']
})
export class HomeComponent implements OnInit {

  listDecks: Array<any>;

  constructor(private _deckService: DeckService) { }

  ngOnInit() {
    this.carregarDecks();
  }

  private carregarDecks() {
    this.listDecks = this._deckService.getDecks();
  }

}
