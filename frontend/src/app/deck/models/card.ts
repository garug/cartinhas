export class Card {
    private _idReference: String;
    private _name: String;
    private _rarity: String;
    private _types: any;
    private _colors: Array<any>;

    set name(name: String) {
        this._name = name;
    }

    get idReference() {
        return this._idReference;
    }

    get types() {
        return this._types;
    }
}
