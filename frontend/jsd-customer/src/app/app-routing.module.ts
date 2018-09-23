/* Copyright josivanSilva (Developer) 2018 */
import { NgModule } from '@angular/core';
import { Routes, RouterModule } from "@angular/router";
import { CustomersComponent } from './customers/customers.component';
import { CustomerComponent } from './customers/customer.component';

const routes: Routes = [
    {
        path: 'customers',
        children: [
          {
            path: '',
            component: CustomersComponent
          },
          {
            path: "add",
            component: CustomerComponent
          },
          {
            path: "details/:id",
            children: [
              {
                path: "",
                component: CustomerComponent,
                data: {
                  breadcrumb: ""
                }
              },
              {
                path: "edit/:id",
                component: CustomerComponent,
                data: {
                  breadcrumb: "Alterar"
                }
              }
            ]
          }
        ]
    },
];

/**
 * AppRoutingModule module class.
 * 
 *  @author josivan@josivansilva.com
 */
@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }