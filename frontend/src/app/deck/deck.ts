export class Deck {
    private _name: string;
    private _types: Array<Number>;
    private _cards: Array<any>;

    constructor(name, types, cards) {
        this._name = name;
        this._types = types;
        this._cards = cards;
        return this;
    }
}