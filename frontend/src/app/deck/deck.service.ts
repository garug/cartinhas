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

  get api() {
    return this._api;
  }

  getDecks(): Observable<Deck[]> {
    return this.http.get<Deck[]>(this.url);
  }

  getDeck(id: Number): Observable<Deck> {
    return this.http.get<Deck>(`${this.url}/${id}`);
  }

  setDeck(deck: Deck): Observable<Deck> {
    return this.http.post<Deck>(this.url, deck);
  }

  getCardAPI(idReference: String): Observable<Card[]> {
    const searchIds = new Array<String>();
    searchIds.push(idReference);
    return this.http.get<Card[]>(`${this.api}/?id=${searchIds.join('|')}`);
  }

  callCards(cards: Array<Card>) {
    let filterId = new Array<String>();
    cards.forEach(c => {
      if (!filterId.find(e => e === c.idReference)) {
        filterId.push(c.idReference);
      }
      if (cards.length - 1 === cards.findIndex(c2 => c2 === c) || filterId.length === 10) {
        this.http.get(`${this.api}/?id=${filterId.join('|')}`).subscribe(response => this.responseToCards(response, cards));
        filterId = new Array<String>();
      }
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
}
