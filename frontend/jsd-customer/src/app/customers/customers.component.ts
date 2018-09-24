/* Copyright josivanSilva (Developer); 2018 */
import { Component, OnInit } from '@angular/core';
import { CustomerService } from '../services/customer.service';
import { Customer } from './customer';
import { Overlay } from 'ngx-modialog';
import { Modal } from 'ngx-modialog/plugins/bootstrap';
import { Functions } from '../util/functions';
import { Constants } from '../util/constants';
import { ActivatedRoute, Router } from '@angular/router';

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

  constructor (private customerService: CustomerService, 
                public modal: Modal,
                private activatedRoute: ActivatedRoute,
                private router: Router) { 

  }

  ngOnInit() {
    this.findAll ();
  }

  public findAll () {    
    this.customerService.getCustomers().subscribe(data => {
      this.customers = data;
      console.log (data);      
    });    
  } 

  /** 
  * Calling event for customer deletion.
  */
 public onDeleteCustomer (customerId) {
   alert ('customerId: ' + customerId);
  const dialogRef = this.modal.confirm()
      .size('sm')
      .showClose(true)
      .keyboard(27)
      .headerClass('modal-header-red')
      .title('Excluir registro?')
      //.body(`<b>` + this.nome.value + `</b>`)
      .okBtn('Excluir')
      .okBtnClass('btn btn-danger')
      .cancelBtn('Cancelar')
      .open();

  dialogRef.result
      .then( 
        result => this.deleteCustomer (customerId)          
      );
 }

    /** 
    * Deletes a Customer.
    */
  private deleteCustomer (customerId) {    
    this.customerService.deleteCustomer (customerId).subscribe(data => {
      if (data != null) {
        if (data.toString() == "true") {          
          Functions.createModalSuccess (this.modal, 'Cliente excluído com sucesso.');
          this.updateCustomersArray (customerId);        
        } else if (data.toString() == "false") {
          Functions.createModalError (this.modal, 'Ocorreu um erro ao excluir o Cliente.');
        }
      }      
    });
  }

  /** 
    * Updates the Customers array.
    */
  private updateCustomersArray (customerId) {
    var arr = new Array<Customer>();
    for (var i = 0; i < this.customers.length; i++) {
      var customer = this.customers[i];
      if (customer.customerId !== customerId) {
        arr.push (customer);
      } 
    }
    this.customers = arr;
  }

}
