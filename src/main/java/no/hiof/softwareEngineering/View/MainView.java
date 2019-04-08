package no.hiof.softwareEngineering.View;
import no.hiof.softwareEngineering.Controller.CustomerDriver;
import no.hiof.softwareEngineering.Controller.OrganizerDriver;
import no.hiof.softwareEngineering.Model.Customer;
import no.hiof.softwareEngineering.Model.Person;

import java.util.Scanner;
import no.hiof.softwareEngineering.Model.Event;
import java.util.ArrayList;

import static no.hiof.softwareEngineering.Controller.SearchEvent.searchCategory;
import static no.hiof.softwareEngineering.Controller.SearchEvent.searchEvents;
import static no.hiof.softwareEngineering.View.CustomerView.runCustomerPart;
import static no.hiof.softwareEngineering.View.OrganizerView.runOrganizer;

public class MainView {

    public void userOptions(){
        Scanner scanner = new Scanner(System.in);
        int option = 0;

        while(option < 6){
            System.out.print("\n(1) Arrangør seksjon // (2) Kunde seksjon // (3) Registrer kunde konto // (4) Registrer ny arrangør // (5) Søk etter arrangement og kategori // (6) Avslutt: ");
            option = scanner.nextInt();
            switch (option){
                case 1: //Organizer part
                    // userLogin(Organizer.getOrganizerList());
                    runOrganizer();
                    break;
                case 2: //Customer part
                    //userLogin(Customer.getCustomerList());
                    runCustomerPart();
                    break;
                case 3:
                    NewUserView.receiveNewCustomerInput();
                    break;
                case 4:
                    NewUserView.receiveNewOrganizerInput();
                    break;
                case 5:
                    search();
                    break;
                case 6:
                    break;
                default:
                    System.out.println("Ikke gyldig valg.");
                    break;
            }
        }
        scanner.close();
    }

    // ToDo: legge inn diverse sjekker på input. Se hva som ligger på Person
    // ToDo: Sjekk på om mailadressen ligger inne allerede?

    /*
    private void registerOrganizerAccont(){
        Scanner input = new Scanner(System.in);

        System.out.print("Firmanavn: ");
        String companyName = input.nextLine();

        //Register new organizer account
        System.out.print("Organisasjonsnummer: ");
        String orgNumber = input.nextLine();

        System.out.print("Epostadresse: ");
        String email = input.nextLine();

        Person.inputEmail(email);



        System.out.print("Passord: ");
        String password = input.nextLine();

        if(option == 4){
            System.out.print("Firmanavn: ");
            String companyName = input.nextLine();

            //Register new organizer account
            System.out.print("Organisasjonsnummer: ");
            String orgNumber = input.nextLine();

            OrganizerDriver.createNewOrganizerAccount(orgNumber, companyName, email, password);
        }
        else if (option == 3){
            System.out.print("Fornavn ");
            String firstname = input.nextLine();


            System.out.print("Etternavn: ");
            String lastname = input.nextLine();

            CustomerDriver.createNewCustomerAccount(firstname,lastname, email, password);
        }
    }


        System.out.print("Etternavn: ");
        String lastname = input.nextLine();

        System.out.print("Epostadresse: ");
        String email = input.nextLine();

        System.out.print("Passord: ");
        String password = input.nextLine();

        OrganizerDriver.createNewOrganizerAccount(firstname,lastname, email, password);

    }*/

    private void search(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Skriv inn '1' for å søke etter arrangement, eller '2' for å søke etter kategori");

        try{
            int option = scanner.nextInt();

            if(option == 1)
                searchAfterEvents();

            else if(option == 2)
                searchAfterCategorys();
            else
                System.out.println("Skriv inn 1 eller 2!");
        }
        catch(Exception exc){
            System.out.println("Skriv inn et tall!");
            search();
        }
    }

    private void searchAfterEvents(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Søk etter arrangement: ");

        String searchStr = scanner.nextLine();

        ArrayList<Event> matches = searchEvents(searchStr);

        if(!matches.isEmpty()){
            System.out.println("Følgende arrangment ble funnet:");
            for (Event evt : matches){
                System.out.println(evt.getEventName());
            }
        }
        else {
            System.out.println("Fant ingen arrangement, vennligst prøv igjen med andre søkeord.");
            search();
        }

    }

    private void searchAfterCategorys(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Søk etter arrangment i kategori: ");

        String searchStr = scanner.nextLine();

        ArrayList<Event> matches = searchCategory(searchStr);

        if(!matches.isEmpty()){
            System.out.println("Følgende arrangment ble funnet:");
            for (Event evt : matches){
                System.out.println(evt.getEventName());
            }
        }
        else {
            System.out.println("Fant ingen arrangement med dette kategoriet, vennligst prøv igjen med andre søkeord.");
            search();
        }
    }
}