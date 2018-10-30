import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Resource } from '../resource';
import { HttpClient } from '@angular/common/http';
import { Deck } from './deck';

@Injectable({
  providedIn: 'root'
})

export class DeckService {

  private url = Resource.getUrl() + "/deck";

  constructor(private http: HttpClient) { }


  setDeck(deck:Deck):Observable<any>{
    return this.http.post(this.url, deck);
  }

  getDecks(): Observable<Deck[]>{
    return this.http.get<Deck[]>(this.url);
  }
/*
  getDecks() {
    return [
      {
        "name": "nome do deck",
        "tipo": ["azul", "preto"],
        "cartas": {
          "mitica": 4,
          "rara": 5,
          "incomum": 5,
          "normal": 4
        }
      }
    ]
  }*/
}
