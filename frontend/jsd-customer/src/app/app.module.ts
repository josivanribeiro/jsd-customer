import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { HeaderComponent } from './header/header.component';
import { CustomersComponent } from './customers/customers.component';
import { CustomerService } from './services/customer.service';
import { LocationStrategy, HashLocationStrategy } from '@angular/common';
import { HttpClientModule } from '@angular/common/http';

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    CustomersComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule
  ],
  providers: [
    CustomerService,
    { provide: LocationStrategy, useClass: HashLocationStrategy }    

  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
