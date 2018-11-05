import { Component, OnInit, Input } from '@angular/core';

@Component({
  selector: 'app-bar-types',
  templateUrl: './bar-types.component.html',
  styleUrls: ['./bar-types.component.scss']
})
export class BarTypesComponent implements OnInit {
  @Input() colors: Array<string>;
  @Input() iconSize = 15;

  constructor() { }

  ngOnInit() {
  }

  hasColor(color: string) {
    return this.colors ? this.colors.find(e => e === color) : true;
  }
}
