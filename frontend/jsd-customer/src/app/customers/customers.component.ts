/* Copyright josivanSilva (Developer); 2018 */
import { Component, OnInit } from '@angular/core';
import { CustomerService } from '../services/customer.service';
import { Customer } from './customer';

/**
 * Customer component class.
 * 
 * @author josivan@josivansilva.com
 *
 */
@Component({
  selector: 'app-customers',
  templateUrl: './customers.component.html'
})
export class CustomersComponent implements OnInit {

  customers : Customer[];

  constructor (private customerService: CustomerService) { }

  ngOnInit() {
    this.findAll ();
  }

  public findAll () {    
    this.customerService.getCustomers().subscribe(data => {
      this.customers = data;
      console.log (data);      
    });    
  } 

}
