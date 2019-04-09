package no.hiof.softwareEngineering.View;

import no.hiof.softwareEngineering.Controller.NewUserAccount;
import no.hiof.softwareEngineering.Model.Customer;
import no.hiof.softwareEngineering.Model.Organizer;

import java.util.Scanner;

import static no.hiof.softwareEngineering.Controller.NewUserAccount.*;

public class NewUserView {
    private static Scanner input = new Scanner(System.in);

    public static String reciveString(String message){
        System.out.print(message);
        String checkString = input.nextLine();
        while(!NewUserAccount.checkStringLength(1, 50, checkString)){
            System.out.print("Feil i input, Prøv på nytt: ");
            checkString = input.nextLine();
        }
        return checkString;
    }

    public static String reciveEmail(){
        System.out.print("E-post: ");
        String email = input.nextLine();
        while(!checkEmail(email)){
            System.out.print("Feil i input, prøv igjen: ");
            email = input.nextLine();
        }
        return email;
    }

    public static String recivePassword(){
        System.out.print("Passord (min 8 tegn, store og små bokstaver, tall og/eller spesialtegn): ");
        String password = input.nextLine();
        while(!checkPassword(password)){
            password = input.nextLine();
        }
        return password;
    }

    public static void receiveNewCustomerInput() {
        String firstname = reciveString("Fornavn: ");
        String lastname = reciveString("Etternavn: ");
        String email = reciveEmail();
        String password = recivePassword();

        Customer customer = new Customer(firstname, lastname, email, password);
        createNewCustomerAccount(customer);
    }

    public static void receiveNewOrganizerInput() {
        String companyName = reciveString("Firmanavn: ");
        String firstname = reciveString("Fornavn: ");
        String lastname = reciveString("Etternavn: ");
        String email = reciveEmail();
        String password = recivePassword();

        Organizer organizer = new Organizer(companyName, email, password, firstname, lastname);
        createNewOrganizerAccount(organizer);
    }
}
