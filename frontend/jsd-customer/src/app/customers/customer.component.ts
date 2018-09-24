/* Copyright josivanSilva (Developer); 2018 */
import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators, FormBuilder} from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { CustomerService } from '../services/customer.service';
import { CustomerType} from './customerType';

/**
 * Customer component class.
 * 
 * @author josivan@josivansilva.com
 *
 */
@Component({
  selector: 'app-customer',
  templateUrl: './customer.component.html'
})
export class CustomerComponent implements OnInit {

  /* Page form attributes */
  customerForm: FormGroup;
  customerId: string;
  customerName: FormControl;
  customerType: FormControl;
  customerMonthlyIncome: FormControl;
  customerRisk: FormControl;
  customerAddress: FormControl;
  customerTotalPatrimony: FormControl;
  customerCurrentDebts: FormControl;
  customerEmployed: FormControl;

  customerTypes = [
    new CustomerType ("Special", "Especial"),
    new CustomerType ("Potential", "Potencial"),
    new CustomerType ("Common", "Comum"),
  ];
  selectedCustomerType: CustomerType = new CustomerType ("","");

  /* Edit mode attributes */
  isAdd: boolean = false;
  isDetails: boolean = false;
  isEdit: boolean = false; 

  constructor (private customerService: CustomerService,              
               private activatedRoute: ActivatedRoute,
               private router: Router) { }

  ngOnInit() {
    this.createFormControls();
    this.createForm();
  }

  /** 
  * Checks the risks.
  */
 public checkRisk (value) {
   if (value <= 2000) {
    this.customerRisk.setValue("C");
   } else if (value > 2000 && value <= 8000) {
    this.customerRisk.setValue("B");
   } else if (value > 8000) {
    this.customerRisk.setValue("A");
   }
 }

  /** 
  * Creates the form controls.
  */
 private createFormControls() {
  this.customerName = new FormControl('', Validators.required);
  this.customerType = new FormControl('', Validators.required);
  this.customerMonthlyIncome = new FormControl('', Validators.required);
  this.customerRisk = new FormControl('', Validators.required);
  this.customerAddress = new FormControl('', Validators.required);
  this.customerTotalPatrimony = new FormControl();
  this.customerCurrentDebts = new FormControl();
  this.customerEmployed = new FormControl();  
 }

/** 
* Creates the form.
*/
private createForm() {
  this.customerForm = new FormGroup({
    customerName: this.customerName,
    customerType: this.customerType,
    customerMonthlyIncome: this.customerMonthlyIncome,
    customerRisk: this.customerRisk,
    customerAddress: this.customerAddress,
    customerTotalPatrimony: this.customerTotalPatrimony,
    customerCurrentDebts: this.customerCurrentDebts,
    customerEmployed: this.customerEmployed,
  });
} 

/** 
* Selects a customer type. 
*/
 public selectCustomerType (value) {
  this.selectedCustomerType = this.customerTypes.filter((item)=> item.value == value)[0];  
 }

}
