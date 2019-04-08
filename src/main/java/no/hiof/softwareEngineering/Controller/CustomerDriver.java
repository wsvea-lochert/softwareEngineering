package no.hiof.softwareEngineering.Controller;

import no.hiof.softwareEngineering.Model.Customer;
import static no.hiof.softwareEngineering.Lists.ListManager.customerList;

public class CustomerDriver {

    public static void createNewCustomerAccount(String firstname, String lastname, String email, String password) {
        Customer customer = new Customer(firstname, lastname, email, password);
        customerList.add(customer);
    }

    public static void createNewCustomerAccount(Customer customer){

        customerList.add(customer);
        System.out.println("Din kundekonto er opprettet!");
    }

}
