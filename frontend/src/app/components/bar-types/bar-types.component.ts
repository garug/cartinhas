import { Component, OnInit, Input } from '@angular/core';

@Component({
  selector: 'app-bar-types',
  templateUrl: './bar-types.component.html',
  styleUrls: ['./bar-types.component.scss']
})
export class BarTypesComponent implements OnInit {
  @Input() types: Array<any>;

  constructor() { }

  ngOnInit() {
  }

  hasColor(color: string) {
    return this.types.find(e => e === color);
  }
}
