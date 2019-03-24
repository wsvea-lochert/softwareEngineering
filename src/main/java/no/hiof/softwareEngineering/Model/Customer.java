package no.hiof.softwareEngineering.Model;

import java.util.ArrayList;
import java.util.Scanner;

public class Customer extends Person{

    private static ArrayList <Customer> customerList = new ArrayList<>();

    public Customer(){ }

    public Customer(String password, String firstname, String lastname, String email){
        super(password, firstname, lastname, email);
        customerList.add(this);
    }

    private void createNewCustomerAccount() {
        Scanner input = new Scanner(System.in);

        super.setFirstName(inputFirstName());

        super.setLastName(inputLastName());

        super.setEmail(inputEmail());
        //ToDo: må legge inn validering på om email adressen allerede finnes i arrayen

        super.setConfirmEmail(inputConfirmEmail(super.getEmail()));

        super.setPhoneNo(inputPhonenumber());

        super.setPassword(inputPassword());

        super.setConfirmpassword(confirmPassword(super.getPassword()));

        customerList.add(this);
        System.out.println("Brukerkonto er nå laget.");

        printCustomerList();
    }

    //driver funksjon for createNewCustomerAccount()
    public static void createAccount(){
        Customer newCustomerAccount = new Customer();
        newCustomerAccount.createNewCustomerAccount();
    }

    private static void printCustomerList(){
        for (Customer customer : customerList){
            System.out.println(customer.getFirstName() + " " + customer.getEmail());
        }
    }

    public static ArrayList<Customer> getCustomerList() {
        return customerList;
    }
}
