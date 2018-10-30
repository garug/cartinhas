export class Deck {
    private _name: string;
    private _raritys: Array<any>;
    private _cards: Array<any>;

    constructor(name, types, cards) {
        this._name = name;
        this._raritys = types;
        this._cards = cards;
        return this;
    }

    get types() {
        return this._raritys;
    }
}
