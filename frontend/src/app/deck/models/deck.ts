import { EnumTypes } from './../../enums/e-types';
import { Card } from './card';
import { Color } from './color';

export class Deck {
    public static types = Object.keys(EnumTypes);

    private id: number;
    private name: string;
    private description: string;
    private colors: Array<Color>;
    private _cards: Array<Card>;
    private countM: number;
    private countR: number;
    private countU: number;
    private countC: number;
    private cardImp: string;


    public get cards() {
        return this._cards;
    }

    public set cards(cards) {
        this._cards = cards;
    }

    constructor(obj?) {
        return Object.assign(this, obj);
    }

    allTypes() {
        return Object.values(EnumTypes);
    }

    list(type: EnumTypes) {
        if (this.cards) {
            const cards = this.cards.filter(e => e.types[0] === type && this.cards.find(e2 => e2.name === e.name) === e);
            return cards.length > 0 ? cards : false;
        }
    }

    countTypes(type: EnumTypes) {
        if (this.cards) {
            return this.cards.filter(e => e.types[0] === type).length;
        }
    }
}
