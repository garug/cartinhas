export class Deck {
    private _id: number;
    private _name: string;
    private _colors: Array<any>;
    private _raritys: Array<any>;
    private _cards: Array<any>;

    constructor(name?, colors?, raritys?, cards?) {
        this._name = name;
        this._colors = colors;
        this._raritys = raritys;
        this._cards = cards;
        return this;
    }

    get types() {
        return this._raritys;
    }
}
