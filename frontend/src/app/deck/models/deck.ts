import { Card } from './card';

export class Deck {
    private _id: number;
    private _name: string;
    private _description: string;
    private _colors: Array<string>;
    private _cards: Array<Card>;
    private _countM: number;
    private _countR: number;
    private _countU: number;
    private _countC: number;
}
