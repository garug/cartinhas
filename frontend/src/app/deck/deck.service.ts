import { Card } from './models/card';
import { Router } from '@angular/router';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';

import { Resource } from '../shared/resource';
import { Deck } from './models/deck';

@Injectable({
  providedIn: 'root'
})

export class DeckService {

  private _url = Resource.getUrl() + '/deck';
  private _api = Resource.apiUrl();

  constructor(
    private http: HttpClient
  ) { }

  get url() {
    return this._url;
  }

  get api(){
    return this._api;
  }

  callDeck(id: Number) {
    const retorno = this.http.get(`${this.url}/${id}`);
    return retorno;
  }

  callCards(cards: Array<any>) {
    const searchIds = new Array<String>();
    let allIds = 1;
    cards.forEach(c => {
      searchIds.push(c.idReference);
      if (allIds === cards.length) {
        this.http.get(`${this.api}/?id=${searchIds.join('|')}`).subscribe(response => this.responseToCards(response, cards));
      }
      allIds++;
      // this.http.get(`${this.api}/?id=${c.idReference}`).subscribe(response => {
      //   const tempCard: Card = response['cards'][0];
      //   c.name = tempCard.name;
      // });
    });
  }

  private responseToCards(response, cards) {
    cards.forEach(card => {
      response['cards'].forEach(cardResponse => {
        if (cardResponse.id === card.idReference) {
          card.name = cardResponse.name;
        }
      });
    });
  }

  setDeck(deck: Deck): Observable<any> {
    return this.http.post(this.url, deck);
  }

  getDeck(id: Number): Observable<Deck> {
    return this.http.get<Deck>(this.url+"/"+id);
  }

  getCardAPI(idReference: String): Observable<any>{
    const searchIds = new Array<String>();
    searchIds.push(idReference);
    return this.http.get(`${this.api}/?id=${searchIds.join('|')}`);
  }

  getDecks(): Observable<Deck[]> {
    return this.http.get<Deck[]>(this.url);
    // return [
    //   {
    //     'id': 1,
    //     'name': 'nome do deck',
    //     'types': ['blue', 'red', 'black', 'green', 'white'],
    //     'raritys': {
    //       'm': 10,
    //       'r': 12,
    //       'u': 14,
    //       'c': 18
    //     }
    //   }
    // ];
  }
}
