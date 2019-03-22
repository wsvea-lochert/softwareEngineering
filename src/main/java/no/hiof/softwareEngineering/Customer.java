package no.hiof.softwareEngineering;

import java.util.ArrayList;
import java.util.Scanner;

public class Customer extends Person{

    private static ArrayList <Customer> customerList = new ArrayList<>();

    public Customer(){
        //customerList.add(this);
    }

    public void createNewCustomerAccount() {
        Scanner input = new Scanner(System.in);

        super.setFirstName(inputFirstName());

        super.setLastName(inputLastName());

        super.setEmail(inputEmail());
        //ToDo: må legge inn validering på om email adressen allerede finnes i arrayen
        /*System.out.print("Gjenta email: ");
        confirmEmail = input.nextLine();*/

        super.setConfirmEmail(inputConfirmEmail(super.getEmail()));

        super.setPhoneNo(inputPhonenumber());

        super.setPassword(inputPassword());

        super.setConfirmpassword(confirmPassword(super.getPassword()));

        customerList.add(this);

        printCustomerList();
    }

    public static void printCustomerList(){
        for (Customer customer : customerList){
            System.out.println(customer.getFirstName() + " " + customer.getEmail());
        }
    }

    public static ArrayList<Customer> getCustomerList() {
        return customerList;
    }
}
