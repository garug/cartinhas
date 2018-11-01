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

  private _sharedDeck: Deck = null;
  private _url = Resource.getUrl() + '/deck';

  constructor(
    private http: HttpClient,
    private router: Router
  ) { }

  get url() {
    return this._url;
  }

  get sharedDeck() {
    return this._sharedDeck;
  }

  set sharedDeck(deck: Deck) {
    this._sharedDeck = deck;
  }


  setDeck(deck: Deck): Observable<any> {
    return this.http.post(this.url, deck);
  }

  callToEdit(deck: Deck) {
    this.router.navigate([`/deck/${deck.id}`]);
  }

  getDecks(): Observable<any[]> {
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
