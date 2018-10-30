import { Component, OnInit } from '@angular/core';
import { DeckService } from '../deck/deck.service';
import { Deck } from '../deck/deck';

@Component({
  selector: 'app-home-component',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']
})
export class HomeComponent implements OnInit {

  constructor(private service:DeckService) { }

  decks:Array<Deck> = [
    {
      "id":1,
      "nome":"Deck 1",
      "tipos": [{"id":1,"nome":"AZUL"}]
    },
    {
      "id":2,
      "nome":"Deck 2",
      "tipos": [{"id":1,"nome":"AZUL"}]
    }
  ];

  public getDecks(){
    this.service.getDecks().subscribe(
      response => this.decks = response
    );
  }

  ngOnInit() {
    this.getDecks();
  }

}
