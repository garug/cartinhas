import { Component, OnInit } from '@angular/core';
import { DeckService } from '../deck/deck.service';
import { Deck } from '../entity/deck';

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
      "cores": [{"id":1,"nome":"AZUL"}],
      "cartas": [{"id":1,"nome":"Carta 1","raridade":"mitica"}],
      "countMitica" : 1,
      "countRara" : 1,
      "countIncomum" : 1,
      "countNormal" : 1
    },
    {
      "id":2,
      "nome":"Deck 2",
      "cores": [{"id":1,"nome":"AZUL"}],
      "cartas": [{"id":2,"nome":"Carta 2","raridade":"mitica"}],
      "countMitica" : 1,
      "countRara" : 1,
      "countIncomum" : 1,
      "countNormal" : 1
    }
  ];

  public getDecks(){
    this.service.getDecks().subscribe(
      response => this.decks = response
    );
  }

  ngOnInit() {
    //this.getDecks();
  }

}
