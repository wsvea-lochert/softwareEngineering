package no.hiof.softwareEngineering.Controller;

import no.hiof.softwareEngineering.Lists.ListManager;
import no.hiof.softwareEngineering.Model.Customer;
import no.hiof.softwareEngineering.Model.Organizer;
import no.hiof.softwareEngineering.View.NewUserView;

import static no.hiof.softwareEngineering.Lists.ListManager.customerList;
import static no.hiof.softwareEngineering.Lists.ListManager.organizerList;

/*Validates the input of a new user account and adds it to the customerList or organizerList*/
public class NewUserAccount {


    /* adds new customer to customerList if it doesn't already exist
    * if customer exists, user will be prompted to fill in information again */
    public static void createNewCustomerAccount(Customer customer){
        if (checkIfCustomerExists(customer.getEmail())) {
            customerList.add(customer);
            System.out.println("Din kundekonto er opprettet!");
        }
        else {
            NewUserView.receiveNewCustomerInput();
        }
    }

    /* adds new organizer to organizerList if it doesn't already exist
     * if organizer exists, user will be prompted to fill in information again */
    public static void createNewOrganizerAccount(Organizer organizer) {
        if (checkIfOrganizerExists(organizer.getEmail())) {
            organizerList.add(organizer);
            System.out.println("Din arrangørkonto er opprettet!");
        }
        else {
            NewUserView.receiveNewOrganizerInput();
        }
    }

    /* loops through the customerList and checks if the given e-mail already exists */
    public static boolean checkIfCustomerExists(String email) {
        boolean notExists = true;

        for (Customer c : customerList) {
            if (email.equals(c.getEmail())) {
                System.out.println("E-post er allerede registrert. Prøv på nytt: ");
                notExists = false;
            }
        }

        return notExists;
    }

    /* loops through the organizerList and checks if the given e-mail already exists */
    public static boolean checkIfOrganizerExists(String email) {
        boolean notExists = true;

        for (Organizer o : organizerList) {
            if (email.equals(o.getEmail())) {
                System.out.println("E-post er allerede registrert. Prøv på nytt: ");
                notExists = false;
            }
        }

        return notExists;
    }

    /* checks if a string is no shorter than minlength and no longer than maxlength */
    public static boolean checkStringLength(int minlength, int maxlength, String inputstring) {
        if (inputstring.length() >= minlength && inputstring.length() <= maxlength){
            return true;
        }
        else{
            return false;
        }
    }

    /* checks if an e-mail address consists of numbers, letters or . + _, followed by an @
     * then another sequence of numbers, letters or . + _, a punctuation, then 2-4
      * instances of any letter a-z */
    public static boolean checkEmail(String email) {
        String regexEmail = "^[-0-9a-zA-Z.+_]+@[-0-9a-zA-Z.+_]+\\.[a-zA-Z]{2,4}";

        if (email.matches(regexEmail)){
            return true;
        }
        else {
            return false;
        }
    }

    /* checks if the password is longer than 8 characters, contains uppercase and lowercase letters
     * and numbers or specials characters, prints a message to the user saying
     * which of the requirements are not met */
    public static boolean checkPassword(String password) {
        //regex: https://riptutorial.com/regex/example/18996/a-password-containing-at-least-1-uppercase--1-lowercase--1-digit--1-special-character-and-have-a-length-of-at-least-of-10
        String uppercase = ".*[A-ZÆØÅ]+.*";
        String lowercase = ".*[a-zæøå]+.*";
        String numbers = ".*[0-9]+.*";
        String specChar = ".*\\W+.*";

        if (password.length() < 8) {
            System.out.print("Passordet må inneholde minst 8 tegn, prøv igjen: ");
            return false;
        }
        else if (!password.matches(uppercase) || !password.matches(lowercase)){
            System.out.println("Passordet må inneholde store og små bokstaver, prøv igjen: ");
            return false;
        }
        else if (!password.matches(numbers) && !password.matches(specChar)){
            System.out.println("Passordet må inneholde tall og/eller spesialtegn, prøv igjen: ");
            return false;
        }
        else {
            return true;
        }
    }
}
