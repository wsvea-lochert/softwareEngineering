package no.hiof.softwareEngineering.Controller;

import no.hiof.softwareEngineering.Model.Customer;
import static no.hiof.softwareEngineering.Lists.ListManager.customerList;

public class CustomerDriver {

    public void createNewCustomerAccount(String firstname, String lastname, String email, String password) {
        Customer customer = new Customer(firstname, lastname, email, password);
        customerList.add(customer);
    }

    public static void printCustomerList(){
        for (Customer customer : customerList){
            System.out.println(customer.getFirstname() + " " + customer.getEmail());
        }
    }
}
