import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})

export class DeckService {

  constructor() { }

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
  }
}
