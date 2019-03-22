package no.hiof.softwareEngineering;

<<<<<<< HEAD
import java.util.Arrays;
import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) {
	// write your code here
        int[] nums = IntStream.range(1, 101).toArray();
        Arrays.stream(nums).forEach(System.out::println);
    }
}
=======
import javax.sound.midi.Soundbank;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

//import static no.hiof.softwareEngineering.Customer.customerList;
//import static no.hiof.softwareEngineering.Organizer.organizerList;

public class Main {
    //static final String CUSTOMER_FILENAME = "customerdb.txt";   /* location of customer database */


    public static void main(String[] args) throws FileNotFoundException {

        //ArrayList <Customer> customerDb = new ArrayList <>();

        //Til bruk hvis vi skal lage fil
        //File customerFile = new File(CUSTOMER_FILENAME);

        //check if customer filename for file which holds all usernames and passwords is valid
        /*while(!customerFile.exists() || customerFile.isDirectory()){ //while loop to locate file
            System.out.printf("Your file name \"%s\" was not found.", customerFile.getName());
            System.out.println("Please specify the name of your input file:");
            String filename = input.nextLine();
            customerFile = new File(filename);
        }
        */

        // Testkunde
        //ToDo: gjør om createNewCustomerAccount() til static slik at objektet opprettes i Organizer
        // Har forsøkt å gjøre det, men da må alt av variabler også gjøres static??
        Customer customer = new Customer();
        //customerList.add(customer);
        customer.createNewCustomerAccount();


        //System.out.println(customer.getEmail() + " " + customer.getFirstName());


        // Testarrangangør
        //ToDo: gjør om createNewOrganizerAccount() til static slik at objektet opprettes i Organizer
        // Har forsøkt å gjøre det, men da må alt av variabler også gjøres static??
        //Organizer organizer = new Organizer(); // Creating a new object
        //Organizer.getOrganizerList().add(organizer); // Adding organizer to the list
        //organizer.createNewOrganizerAccount();

        //kjører login delen - Enis
        //Login.loginOptions();



    }
}
>>>>>>> parent of 50a581e... Merging
