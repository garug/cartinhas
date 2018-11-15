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

  constructor(
    private http: HttpClient
  ) { }

  get url() {
    return this._url;
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
}
