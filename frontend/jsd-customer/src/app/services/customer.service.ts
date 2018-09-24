/* Copyright josivanSilva (Developer); 2018 */
import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders, HttpParams, HttpResponse}  from '@angular/common/http';
import {Http, Response, Headers} from "@angular/http";
import {Customer} from '../customers/customer';
//import 'rxjs/add/operator/map';
import { map } from 'rxjs/operators';

/**
 * Service class that represents Customers.
 * 
 *  @author josivan@josivansilva.com
 */
@Injectable()
export class CustomerService {

    private baseUrl: string;

    constructor (private http: HttpClient) {
        this.baseUrl = "http://localhost:8080/jsd-customer/rest/customers";
        
    }

    /** 
    * Gets the Customers. 
    */
    public getCustomers() {
        return this.http.get<Customer[]>(this.baseUrl).pipe (map((res:Customer[]) => res));
    }    

    /** 
    * Inserts a Customer.
    */
    public insertCustomer (customer) {                 
        let body = JSON.stringify(customer);
        return this.http.post<Response>(this.baseUrl + '/', body, {
            headers: new HttpHeaders().set('Content-Type', 'application/json'), observe:'response'
        }).pipe(map((res) => res));
    }

    /** 
    * Gets the Customer by id.
    */
    public getCustomerById (id) {                 
        return this.http.get(this.baseUrl + '/' + id).pipe(map((res:Customer) => res));
    }

    /** 
    * Deletes the Customer by id.
    */
    public deleteCustomer (id) {                 
        return this.http.delete<Response>(this.baseUrl + '/' + id).pipe(map((res) => res));
    }

    /** 
    * Updates the Customer.
    */
    public updateCustomer (customer: Customer) {                 
        let body = JSON.stringify(customer);
        return this.http.put<Response>(this.baseUrl + '/' + customer.customerId, body, {
            headers: new HttpHeaders().set('Content-Type', 'application/json')}).pipe(map((res) => res));
    }

}