import { Tipo } from "./tipo";
import { Carta } from "./carta";
import { Cor } from "./cor";

export class Deck {
    id : number;
    nome : string | null;
    cores : Array<Cor>;
    cartas : Array<Carta>;
    countMitica : number;
    countRara : number;
    countIncomum : number;
    countNormal : number;

}