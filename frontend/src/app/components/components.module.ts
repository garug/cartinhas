import { RouterModule } from '@angular/router';
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { DeckItemComponent } from './deck-item/deck-item.component';
import { BarTypesComponent } from './bar-types/bar-types.component';
import { BarRaritysComponent } from './bar-raritys/bar-raritys.component';

@NgModule({
  imports: [
    CommonModule,
    RouterModule
  ],
  exports: [
    BarRaritysComponent,
    BarTypesComponent,
    DeckItemComponent
  ],
  declarations: [
    BarRaritysComponent,
    BarTypesComponent,
    DeckItemComponent
  ]
})
export class ComponentsModule { }
