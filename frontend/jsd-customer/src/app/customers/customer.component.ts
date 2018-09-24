/* Copyright josivanSilva (Developer); 2018 */
import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators, FormBuilder} from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { CustomerService } from '../services/customer.service';
import { CustomerType} from './customerType';
import { Overlay } from 'ngx-modialog';
import { Modal } from 'ngx-modialog/plugins/bootstrap';
import { Functions } from '../util/functions';
import { Constants } from '../util/constants';
import { Customer } from './customer';

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

  subscribe: any;

  constructor (private customerService: CustomerService,              
               private activatedRoute: ActivatedRoute,
               private router: Router,
               public modal: Modal) { }

  ngOnInit() {
    
    this.createFormControls();
    this.createForm();
    this.setEditMode ();

    this.subscribe = this.activatedRoute.params.subscribe(params => {
      this.customerId = params['id'];      
      //this.getApontamentoById (this.customerId);      
    });

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
  * Calling event for customer insertion.
  */
 public onInsertCustomer() {
  const dialogRef = this.modal.confirm()
      .size('sm')
      .showClose(true)
      .keyboard(27)
      .headerClass('modal-header-blue')
      .title('Incluir registro?')
      .okBtn('Incluir')
      .cancelBtn('Cancelar')
      .open();

  dialogRef.result
      .then( 
        result => this.insertCustomer()          
      );
}

/** 
* Saves a Customer.
*/
public insertCustomer() {    

  console.log ('this.customerName.valid ' + this.customerName.valid);
  console.log ('this.customerType.valid ' + this.customerType.valid);
  console.log ('this.customerMonthlyIncome.valid ' + this.customerMonthlyIncome.valid);
  console.log ('this.customerRisk.valid ' + this.customerRisk.valid);
  console.log ('this.customerAddress.valid ' + this.customerAddress.valid);
  console.log ('this.customerType.value:' + this.customerType.value);

  if (this.customerForm.invalid) {
    Functions.createModalAlert(this.modal, 'É necessário preencher todos os campos.');
    return;
  }    
  let customer = new Customer();
  customer.customerId = null;
  customer.customerName = this.customerName.value;
  customer.customerType = this.selectedCustomerType.value;
  customer.customerMonthlyIncome = this.customerMonthlyIncome.value;
  customer.customerRisk = this.customerRisk.value;
  customer.customerAddress = this.customerAddress.value;
  customer.customerTotalPatrimony = this.customerTotalPatrimony.value;
  customer.customerCurrentDebts = this.customerCurrentDebts.value;
  customer.customerEmployed = this.customerEmployed.value;

  this.customerService.insertCustomer (customer).subscribe(data => {            
    if (data != null) {
      if (data.status === Constants.HTTP_STATUS_CODE_OK) {          
        Functions.createModalSuccess (this.modal, 'Cliente incluído com sucesso.');
        this.router.navigate([Constants.CUSTOMERS_LIST_PATH]);
      } else if (data.status >= 401 && data.status < 500) {
        Functions.createModalError(this.modal, 'Ocorreu um erro no lado cliente.');
      } else if (data.status >= 500 && data.status < 600) {
        Functions.createModalError(this.modal, 'Ocorreu um erro no lado servidor.');
      }
    }      
  });
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
  this.customerTotalPatrimony = new FormControl(null);
  this.customerCurrentDebts = new FormControl(null);
  this.customerEmployed = new FormControl(null);  
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

 /** 
  * Sets the page edit mode.
  */
 private setEditMode () {    
  if (Functions.urlContainsPathByRegex(Constants.CUSTOMERS_EDIT_PATH_REGEX)) {
    this.isEdit = true;      
  } else if (Functions.urlContainsPathByRegex(Constants.CUSTOMERS_DETAILS_PATH_REGEX)) {
    this.isDetails = true;      
  } else if (Functions.urlContainsPath(Constants.CUSTOMERS_ADD_PATH)) {
    this.isAdd = true;
  }
}

/* Called when a directive, pipe or service is destroyed */
private ngOnDestroy() {
  this.subscribe.unsubscribe();
}

}
