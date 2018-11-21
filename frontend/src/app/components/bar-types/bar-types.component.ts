import { Component, OnInit, Input, ViewChild, AfterViewInit, ElementRef } from '@angular/core';

@Component({
  selector: 'app-bar-types',
  templateUrl: './bar-types.component.html',
  styleUrls: ['./bar-types.component.scss']
})
export class BarTypesComponent implements OnInit, AfterViewInit {
  @Input() colors: Array<string>;
  @Input() mana: String;
  @Input() iconSize = 15;
  @ViewChild('manaBar') manaBar: ElementRef;

  constructor() { }

  ngOnInit() {
  }

  ngAfterViewInit() {
    if (this.mana) {
      const temp = this.mana
        // Colors
        .replace(/{G}/g, `<img style="width: ${this.iconSize}px" src="assets/icons/mana/g.svg">`)
        .replace(/{R}/g, `<img style="width: ${this.iconSize}px" src="assets/icons/mana/r.svg">`)
        .replace(/{B}/g, `<img style="width: ${this.iconSize}px" src="assets/icons/mana/b.svg">`)
        .replace(/{W}/g, `<img style="width: ${this.iconSize}px" src="assets/icons/mana/w.svg">`)
        .replace(/{U}/g, `<img style="width: ${this.iconSize}px" src="assets/icons/mana/u.svg">`)
        // Incolors
        .replace(/{X}/g, `<img style="width: ${this.iconSize}px" src="assets/icons/mana/x.svg">`)
        .replace(/\{0}/g, `<img style="width: ${this.iconSize}px" src="assets/icons/mana/0.svg">`)
        .replace(/\{1}/g, `<img style="width: ${this.iconSize}px" src="assets/icons/mana/1.svg">`)
        .replace(/\{2}/g, `<img style="width: ${this.iconSize}px" src="assets/icons/mana/2.svg">`)
        .replace(/\{3}/g, `<img style="width: ${this.iconSize}px" src="assets/icons/mana/3.svg">`)
        .replace(/\{4}/g, `<img style="width: ${this.iconSize}px" src="assets/icons/mana/4.svg">`)
        .replace(/\{5}/g, `<img style="width: ${this.iconSize}px" src="assets/icons/mana/5.svg">`)
        .replace(/\{6}/g, `<img style="width: ${this.iconSize}px" src="assets/icons/mana/6.svg">`)
        .replace(/\{7}/g, `<img style="width: ${this.iconSize}px" src="assets/icons/mana/7.svg">`)
        .replace(/\{8}/g, `<img style="width: ${this.iconSize}px" src="assets/icons/mana/8.svg">`)
        .replace(/\{9}/g, `<img style="width: ${this.iconSize}px" src="assets/icons/mana/9.svg">`)
        // Two colors
        .replace(/{B\/G}/g, `<img style="width: ${this.iconSize}px" src="assets/icons/mana/BG.svg">`)
        .replace(/{B\/P}/g, `<img style="width: ${this.iconSize}px" src="assets/icons/mana/BP.svg">`)
        .replace(/{B\/R}/g, `<img style="width: ${this.iconSize}px" src="assets/icons/mana/BR.svg">`)
        .replace(/{G\/P}/g, `<img style="width: ${this.iconSize}px" src="assets/icons/mana/GP.svg">`)
        .replace(/{G\/U}/g, `<img style="width: ${this.iconSize}px" src="assets/icons/mana/GU.svg">`)
        .replace(/{G\/W}/g, `<img style="width: ${this.iconSize}px" src="assets/icons/mana/GW.svg">`)
        .replace(/{R\/G}/g, `<img style="width: ${this.iconSize}px" src="assets/icons/mana/RG.svg">`)
        .replace(/{R\/P}/g, `<img style="width: ${this.iconSize}px" src="assets/icons/mana/RP.svg">`)
        .replace(/{R\/W}/g, `<img style="width: ${this.iconSize}px" src="assets/icons/mana/RW.svg">`)
        .replace(/{U\/B}/g, `<img style="width: ${this.iconSize}px" src="assets/icons/mana/UB.svg">`)
        .replace(/{U\/P}/g, `<img style="width: ${this.iconSize}px" src="assets/icons/mana/UP.svg">`)
        .replace(/{U\/R}/g, `<img style="width: ${this.iconSize}px" src="assets/icons/mana/UR.svg">`)
        .replace(/{W\/B}/g, `<img style="width: ${this.iconSize}px" src="assets/icons/mana/WB.svg">`)
        .replace(/{W\/P}/g, `<img style="width: ${this.iconSize}px" src="assets/icons/mana/WP.svg">`)
        .replace(/{W\/U}/g, `<img style="width: ${this.iconSize}px" src="assets/icons/mana/WU.svg">`)
        ;
      this.manaBar.nativeElement.innerHTML = temp;  
    }
  }

  hasColor(color: string) {
    return this.colors ? this.colors.find(e => e === color) : true;
  }
}
