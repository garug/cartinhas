import { Component, OnInit, Input } from '@angular/core';
import { Cor } from 'src/app/entity/cor';

@Component({
  selector: 'app-bar-types',
  templateUrl: './bar-types.component.html',
  styleUrls: ['./bar-types.component.scss']
})
export class BarTypesComponent implements OnInit {
  @Input() types: Array<Cor>;
  @Input() iconSize = 15;

  constructor() { }

  ngOnInit() {
  }

  hasColor(color: string) {
    if (this.types) {
      return this.types.find(e => e.nome === color);
    }
    return true;
  }
}
