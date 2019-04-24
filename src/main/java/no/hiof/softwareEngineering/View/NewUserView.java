package no.hiof.softwareEngineering.View;
import no.hiof.softwareEngineering.Model.Customer;
import no.hiof.softwareEngineering.Model.Organizer;

import java.util.Scanner;

import static no.hiof.softwareEngineering.Controller.NewUserAccount.*;

/* Prompts users to input data for creating a new account and sends it to methods in the
 * NewUserAccount class for validation and to add it to the customerList or organizerList */
public class NewUserView {

    private static Scanner input = new Scanner(System.in);

    /* collects data for a new customer account. A new Customer object
     * is created and sent to the method createNewCustomerAccount() which adds it to the customerList*/
    public static void receiveNewCustomerInput() {
        String firstname = receiveString("Fornavn: ");
        String lastname = receiveString("Etternavn: ");
        String email = receiveEmail();
        String password = receivePassword();

        Customer customer = new Customer(firstname, lastname, email, password);
        createNewCustomerAccount(customer);
    }

    /* collects data for a new organizer account. A new Organizer object
     * is created and sent to the method createNewOrganizerAccount() which adds it to the organizerList*/
    public static void receiveNewOrganizerInput() {
        String companyName = receiveString("Firmanavn: ");
        String firstname = receiveString("Fornavn: ");
        String lastname = receiveString("Etternavn: ");
        String email = receiveEmail();
        String password = receivePassword();

        Organizer organizer = new Organizer(companyName, email, password, firstname, lastname);
        createNewOrganizerAccount(organizer);
    }

    /* promts message to user, receives user input. User method checkStringLentgh() to checks if input length is
     * between 1 and 50, if it's not, user is prompted to write input again*/
    public static String receiveString(String message){
        System.out.print(message);
        String checkString = input.nextLine();
        while(!checkStringLength(1, 50, checkString)){
            System.out.print("Feil i input, Prøv på nytt: ");
            checkString = input.nextLine();
        }
        return checkString;
    }

    /* prompts user to write e-mail address, recieves user input. Uses methods checkEmail()
      * and checkStringLength() to check if email is valid and between 6 and 254 characters,
      * if not, user is prompted to write e-mail again */
    public static String receiveEmail(){
        System.out.print("E-post: ");
        String email = input.nextLine();
        while(!checkEmail(email) || !checkStringLength(6, 254, email)){
            System.out.print("Feil i input, prøv igjen: ");
            email = input.nextLine();
        }
        return email;
    }

    /* prompts user to write chosen password, recieves user input. Uses method checkPassword() to
     * check if password is valid, if not, user is prompted to write password again */
    public static String receivePassword(){
        System.out.print("Passord (min 8 tegn, store og små bokstaver, tall og/eller spesialtegn): ");
        String password = input.nextLine();
        while(!checkPassword(password)){
            password = input.nextLine();
        }
        return password;
    }
}
