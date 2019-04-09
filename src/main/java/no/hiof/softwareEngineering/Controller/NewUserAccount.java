package no.hiof.softwareEngineering.Controller;

import no.hiof.softwareEngineering.Model.Customer;
import no.hiof.softwareEngineering.Model.Organizer;
import no.hiof.softwareEngineering.View.NewUserView;

import static no.hiof.softwareEngineering.Lists.ListManager.customerList;
import static no.hiof.softwareEngineering.Lists.ListManager.organizerList;

public class NewUserAccount {

    public static void receivesNewCustomer(Customer customer) {
        if (!checkStringLength(1, 50, customer.getFirstname())) {
            System.out.println("Feil i input: fornavn. Prøv på nytt.");
            String updatedFirstname = NewUserView.updateInput();
            customer.setFirstname(updatedFirstname);
            receivesNewCustomer(customer);
        }
        else if (!checkStringLength(1, 50, customer.getLastname())) {
            System.out.println("Feil i input: etternavn. Prøv på nytt.");
            String updatedLastname = NewUserView.updateInput();
            customer.setLastname(updatedLastname);
            receivesNewCustomer(customer);
        }
        else if (!checkEmail(customer.getEmail())) {
            System.out.println("Feil i input: e-post. Prøv på nytt.");
            String updatedEmail = NewUserView.updateInput();
            customer.setEmail(updatedEmail);
            receivesNewCustomer(customer);
        }
        else if (!checkPassword(customer.getPassword())) {
            String updatedPassword = NewUserView.updateInput();
            customer.setPassword(updatedPassword);
            receivesNewCustomer(customer);
        }

        createNewCustomerAccount(customer);
    }

    public static void createNewCustomerAccount(Customer customer){
        customerList.add(customer);
        System.out.println("Din kundekonto er opprettet!");
    }

    public static void receivesNewOrganizer(Organizer organizer) {
        if (!checkEmail(organizer.getEmail())) {
            System.out.println("Feil i input: e-post. Prøv på nytt.");
            String updatedEmail = NewUserView.updateInput();
            organizer.setEmail(updatedEmail);
            receivesNewOrganizer(organizer);
        }
        else if (!checkPassword(organizer.getPassword())) {
            String updatedPassword = NewUserView.updateInput();
            organizer.setPassword(updatedPassword);
            receivesNewOrganizer(organizer);
        }

        createNewOrganizerAccount(organizer);
    }

    public static void createNewOrganizerAccount(Organizer organizer) {

        organizerList.add(organizer);
        System.out.println("Din arrangørkonto er opprettet!");
    }

    public static boolean checkStringLength(int minlength, int maxlength, String inputstring) {

        if (inputstring.length() >= minlength && inputstring.length() <= maxlength){
            return true;
        }
        else{
            return false;
        }
    }

    public static boolean checkEmail(String email) {
        String regexEmail = "^[-0-9a-zA-Z.+_]+@[-0-9a-zA-Z.+_]+\\.[a-zA-Z]{2,4}";

        if (email.matches(regexEmail)){
            return true;
        }
        else {
            return false;
        }
    }

    public static boolean checkPassword(String password) {
        //regex hentet fra: https://riptutorial.com/regex/example/18996/a-password-containing-at-least-1-uppercase--1-lowercase--1-digit--1-special-character-and-have-a-length-of-at-least-of-10
        String uppercase = "(?=.*[A-Z])";
        String lowercase = "(?=.*[a-z])";
        String numbers = "(?=.*[0-9])";
        String specChar = "(?=.*\\W)";

        if (password.length() < 8) {
            System.out.println("Passordet må inneholde minst 8 tegn.");
            return false;
        }
        /*else if (!password.matches(uppercase) || !password.matches(lowercase)){
            System.out.println("Passordet må inneholde store og små bokstaver.");
            return false;
        }
        else if (!password.contains(numbers) && !password.contains(specChar)){
            System.out.println("Passordet må inneholde tall og/eller spesialtegn.");
            return false;
        }*/
        else {
            return true;
        }
    }
}
