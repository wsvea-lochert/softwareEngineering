package no.hiof.softwareEngineering;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static final String CUSTOMER_FILENAME = "customerdb.txt";   // location of username-password database


    public static void main(String[] args) throws FileNotFoundException {

        String firstName;
        String lastName;
        String userName;
        String password;
        String confirmpassword;
        String email;
        String confirmEmail;
        String phoneNo;
        ArrayList <Customer> customerDb = new ArrayList <>();

        Scanner input = new Scanner(System.in);   // user input scanner

        File customerFile = new File(CUSTOMER_FILENAME);

        //check if customer filename for file which holds all usernames and passwords is valid
        while(!customerFile.exists() || customerFile.isDirectory()){ //while loop to locate file
            System.out.printf("Your file name \"%s\" was not found.", customerFile.getName());
            System.out.println("Please specify the name of your input file:");
            String filename = input.nextLine();
            customerFile = new File(filename);
        }

        //Register new customer account
        System.out.print("Fornavn: ");
        firstName = input.nextLine();
        System.out.print("Etternavn: ");
        lastName = input.nextLine();
        System.out.print("Email : ");
        email = input.nextLine();
        System.out.print("Gjenta email: ");
        confirmEmail = input.nextLine();
        System.out.print("Telefonnummer: ");
        phoneNo = input.nextLine();
        System.out.print("Ønsket brukernavn: ");
        userName = input.nextLine();
        System.out.print("Ønsket passord: ");
        password = input.nextLine();
        System.out.print("Gjenta passord: ");
        confirmpassword = input.nextLine();

        // Test
        Customer customer = new Customer(userName, password, firstName, lastName, email, phoneNo);

    }
}