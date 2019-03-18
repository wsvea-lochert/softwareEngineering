package no.hiof.softwareEngineering;

import javax.sound.midi.Soundbank;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static final String CUSTOMER_FILENAME = "customerdb.txt";   // location of username-password database


    public static void main(String[] args) throws FileNotFoundException {

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

        // Testkunde
        /*Customer customer = new Customer();
        customer.createNewCustomerAccount();

        System.out.println(customer.getEmail() + " " + customer.getFirstName());
        */

        // Testarrangangør
        Organizer org = new Organizer();
        org.createNewOrganizerAccount();

        System.out.println(org.getCompanyName());



    }
}