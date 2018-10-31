import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Resource } from '../shared/resource';
import { HttpClient } from '@angular/common/http';
import { Deck } from '../entity/deck';

@Injectable({
  providedIn: 'root'
})

export class DeckService {

  private url = Resource.getUrl() + '/deck';

  constructor(private http: HttpClient) { }


  setDeck(deck: Deck): Observable<any> {
    return this.http.post(this.url, deck);
  }

  getDecks(): Observable<Deck[]> {
    return this.http.get<Deck[]>(this.url);
  }
  /*
    getDecks() {
      return [
        {
          'id': 1,
          'name': 'nome do deck',
          'types': ['blue', 'red', 'black', 'green', 'white'],
          'raritys': {
            'm': 10,
            'r': 12,
            'u': 14,
            'c': 18
          }
        }
      ]
    }*/
}
