import { RouterModule } from '@angular/router';
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { DeckItemComponent } from './deck-item/deck-item.component';
import { BarTypesComponent } from './bar-types/bar-types.component';

@NgModule({
  imports: [
    CommonModule,
    RouterModule
  ],
  exports: [
    BarTypesComponent,
    DeckItemComponent
  ],
  declarations: [
    BarTypesComponent,
    DeckItemComponent
  ]
})
export class ComponentsModule { }
