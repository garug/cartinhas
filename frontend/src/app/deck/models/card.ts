export class Card {
    private _id: Number;
    private _name: String;
    private _rarity: String;
    private _colors: Array<any>;

    set name(name: String) {
        this._name = name;
    }
}
