export class Deck {
    private _id: number;
    private _name: string;
    private _types: Array<any>;
    private _raritys: Array<any>;
    private _cards: Array<any>;

    constructor(name, types, raritys, cards) {
        this._name = name;
        this._types = types;
        this._raritys = raritys;
        this._cards = cards;
        return this;
    }

    get types() {
        return this._raritys;
    }
}
