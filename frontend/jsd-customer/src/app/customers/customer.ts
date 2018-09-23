/* Copyright josivanSilva (Developer); 2018 */

/**
 * Customer typescript class.
 * 
 * @author josivan@josivansilva.com
 *
 */
export interface Customer {
    customerId: number;
    customerType: string;
    customerName: string;
    customerMonthlyIncome: number;
    customerRisk: string;
    customerAddress: string;
    customerTotalPatrimony?: number;
    customerCurrentDebts?: number;
    customerEmployed?: boolean;
}
