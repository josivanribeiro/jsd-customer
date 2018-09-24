/* Copyright josivanSilva (Developer); 2018 */
/**
 * Class with useful constants.
 * 
 *  @author josivan@josivansilva.com
 */
export class Constants {
    
    /* HTTP Status Codes */
    static readonly HTTP_STATUS_CODE_OK = 200;
    static readonly HTTP_STATUS_CODE_NO_CONTENT = 204;    
    static readonly HTTP_STATUS_CODE_BAD_REQUEST = 400;

    /* Apontamentos path constants */
    static readonly CUSTOMERS_LIST_PATH = "/customers";
    static readonly CUSTOMERS_ADD_PATH = "/customers/add";
    static readonly CUSTOMERS_DETAILS_PATH = "/customers/details/";
    static readonly CUSTOMERS_DETAILS_PATH_REGEX = "\/customers\/details\/[0-9]+";
    static readonly CUSTOMERS_EDIT_PATH_REGEX = "\/customers\/details\/[0-9]+\/edit\/[0-9]+";
    
}