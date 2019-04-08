package no.hiof.softwareEngineering.View;

import no.hiof.softwareEngineering.Controller.NewUserAccount;
import no.hiof.softwareEngineering.Model.Customer;
import no.hiof.softwareEngineering.Model.Organizer;

import java.util.Scanner;

public class NewUserView {
    private static Scanner input = new Scanner(System.in);

    public static void receiveNewCustomerInput() {
        System.out.print("Fornavn: ");
        String firstname = input.nextLine();

        System.out.print("Etternavn: ");
        String lastname = input.nextLine();

        System.out.print("E-post: ");
        String email = input.nextLine();

        System.out.print("Passord (min 8 tegn, store og små bokstaver, tall og/eller spesialtegn): ");
        String password = input.nextLine();

        Customer customer = new Customer(firstname, lastname, email, password);
        NewUserAccount.receivesNewCustomer(customer);
    }

    public static void receiveNewOrganizerInput() {
        System.out.print("Organisasjonsnummer: ");
        String orgNo = input.nextLine();

        System.out.print("Firmanavn: ");
        String companyName = input.nextLine();

        System.out.print("E-post: ");
        String email = input.nextLine();

        System.out.print("Passord (min 8 tegn, store og små bokstaver, tall og/eller spesialtegn): ");
        String password = input.nextLine();

        Organizer organizer = new Organizer(orgNo, companyName, email, password);
        NewUserAccount.receivesNewOrganizer(organizer);
    }

    public static String updateInput() {
        String updatedString = input.nextLine();
        return updatedString;
    }
}
