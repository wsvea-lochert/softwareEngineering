package no.hiof.softwareEngineering;

import java.util.Scanner;

public class Customer extends Person{


    public Customer(){ }

    public void createNewCustomerAccount() {
        Scanner input = new Scanner(System.in);

        //Register new customer account
        System.out.print("Fornavn: ");
        firstName = input.nextLine();

        System.out.print("Etternavn: ");
        lastName = input.nextLine();

        System.out.print("Email: ");
        email = input.nextLine();

        System.out.print("Gjenta email: ");
        confirmEmail = input.nextLine();

        System.out.print("Telefonnummer: ");
        phoneNo = input.nextLine();

        System.out.print("Ønsket passord: ");
        password = input.nextLine();

        System.out.print("Gjenta passord: ");
        confirmpassword = input.nextLine();
    }
}
