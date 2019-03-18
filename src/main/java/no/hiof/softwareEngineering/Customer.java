package no.hiof.softwareEngineering;

import java.util.Scanner;

public class Customer extends Person{


    public Customer(){ }

    public void createNewCustomerAccount() {
        Scanner input = new Scanner(System.in);

        firstName = inputFirstName(firstName);

        lastName = inputLastName(lastName);

        email = inputEmail(email);

        System.out.print("Gjenta email: ");
        confirmEmail = input.nextLine();

        System.out.print("Telefonnummer: ");
        phoneNo = Integer.parseInt(input.nextLine());

        System.out.print("Ønsket passord: ");
        password = input.nextLine();

        System.out.print("Gjenta passord: ");
        confirmpassword = input.nextLine();
    }
}
