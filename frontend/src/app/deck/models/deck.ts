import { EnumTypes } from './../../enums/e-types';
import { Card } from './card';
import { Color } from './color';

export class Deck {
    public static types = Object.keys(EnumTypes);

    private _id: number;
    private _name: string;
    private description: string;
    private _colors: Array<Color>;
    private _cards: Array<Card>;
    private countM: number;
    private countR: number;
    private countU: number;
    private countC: number;
    private _cardImp: string;

    public get id() {
        return this._id;
    }

    public set id(id: number) {
        this._id = id;
    }

    public get name() {
        return this._name;
    }

    public set name(name: string) {
        this._name = name;
    }

    public get colors() {
        return this._colors;
    }

    public get cardImp() {
        return this._cardImp;
    }

    public set cardImp(cardImp: string) {
        this._cardImp = cardImp;
    }

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

    get deckImage() {
        return this.cards.find(e => e.imageUrl != null && this.contCard(e) > 0).imageUrl;
    }

    contCard(card: Card) {
        return this.cards.reduce((prevVal, elem) => {
            return elem.name === card.name ? prevVal += 1 : prevVal;
        }, 0);
    }
}
