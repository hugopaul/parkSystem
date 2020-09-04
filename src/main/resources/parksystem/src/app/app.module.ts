import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HelloComponent } from './hello/hello.component';
import { ParkSystemComponent } from './park-system/park-system.component';

@NgModule({
  declarations: [
    AppComponent,
    HelloComponent,
    ParkSystemComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    VeiculosModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
