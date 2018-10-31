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
    if (this.colors) {
      return this.colors.find(e => color === color);
    }
    return true;
  }
}
