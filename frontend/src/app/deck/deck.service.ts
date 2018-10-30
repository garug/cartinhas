import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})

export class DeckService {

  constructor() { }

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
    ];
  }
}
