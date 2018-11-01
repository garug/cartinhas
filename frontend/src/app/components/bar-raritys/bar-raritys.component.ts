import { Component, OnInit, Input } from '@angular/core';

@Component({
  selector: 'app-bar-raritys',
  templateUrl: './bar-raritys.component.html'
})
export class BarRaritysComponent implements OnInit {
  @Input() deck = null;

  constructor() { }

  ngOnInit() {
  }

}
