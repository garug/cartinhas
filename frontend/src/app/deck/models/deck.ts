import { Card } from './card';
import { Color } from './color';

export class Deck {
    private _id: number;
    private _name: string;
    private _description: string;
    private _colors: Array<Color>;
    private _cards: Array<Card>;
    private _countM: number;
    private _countR: number;
    private _countU: number;
    private _countC: number;
    private _cardImp: string;

    get id() {
        return this.id;
    }
}
