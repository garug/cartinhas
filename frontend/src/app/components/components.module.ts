import { RouterModule } from '@angular/router';
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { DeckItemComponent } from './deck-item/deck-item.component';
import { BarTypesComponent } from './bar-types/bar-types.component';
import { BarRaritysComponent } from './bar-raritys/bar-raritys.component';
import { TooltipComponent } from './tooltip/tooltip.component';

@NgModule({
  imports: [
    CommonModule,
    RouterModule
  ],
  exports: [
    BarRaritysComponent,
    BarTypesComponent,
    DeckItemComponent,
    TooltipComponent,
  ],
  declarations: [
    BarRaritysComponent,
    BarTypesComponent,
    DeckItemComponent,
    TooltipComponent
  ]
})
export class ComponentsModule { }
