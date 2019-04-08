package no.hiof.softwareEngineering.View;

import no.hiof.softwareEngineering.Controller.NewUserAccount;
import no.hiof.softwareEngineering.Model.Customer;
import no.hiof.softwareEngineering.Model.Organizer;

import java.util.Scanner;

public class NewUserView {
    private static Scanner input = new Scanner(System.in);

    public static void receiveNewCustomerInput() {
        String firstname = generalInputReceiver("Fornavn: ");
        String lastname = generalInputReceiver("Etternavn: ");
        String email = generalInputReceiver("E-post: ");
        String password = generalInputReceiver("Passord (min 8 tegn, store og små bokstaver, tall og/eller spesialtegn): ");

        Customer customer = new Customer(firstname, lastname, email, password);
        NewUserAccount.receivesNewCustomer(customer);
    }

    public static void receiveNewOrganizerInput() {
        String companyName = generalInputReceiver("Firmanavn: ");
        String firstname = generalInputReceiver("Fornavn: ");
        String lastname = generalInputReceiver("Etternavn: ");
        String email = generalInputReceiver("E-post: ");
        String password = generalInputReceiver("Passord (min 8 tegn, store og små bokstaver, tall og/eller spesialtegn): ");

        Organizer organizer = new Organizer(companyName, email, password, firstname, lastname);
        NewUserAccount.receivesNewOrganizer(organizer);
    }

    public static String generalInputReceiver(String message) {
        System.out.print(message);
        return input.nextLine();
    }

    public static String updateInput() {
        String updatedString = input.nextLine();
        return updatedString;
    }
}
