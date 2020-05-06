import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { IpoRoutingModule } from './ipo-routing.module';
import { IpoComponent } from './ipo.component';


@NgModule({
  declarations: [IpoComponent],
  imports: [
    CommonModule,
    IpoRoutingModule
  ]
})
export class IpoModule { }
