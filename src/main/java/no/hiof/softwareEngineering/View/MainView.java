package no.hiof.softwareEngineering.View;

import java.util.Scanner;
import no.hiof.softwareEngineering.Model.Event;
import java.util.ArrayList;

import static no.hiof.softwareEngineering.Controller.SearchEvent.searchCategory;
import static no.hiof.softwareEngineering.Controller.SearchEvent.searchEvents;
import static no.hiof.softwareEngineering.View.CustomerView.runCustomerPart;
import static no.hiof.softwareEngineering.View.NewUserView.receiveNewCustomerInput;
import static no.hiof.softwareEngineering.View.NewUserView.receiveNewOrganizerInput;
import static no.hiof.softwareEngineering.View.OrganizerView.runOrganizer;

public class MainView {

    public void userOptions(){
        Scanner scanner = new Scanner(System.in);
        int option = 0;

        boolean exit = false;
        while(!exit){
            System.out.print("\n(1) Arrangør seksjon // (2) Kunde seksjon // (3) Registrer kunde konto // (4) Registrer ny arrangør // (5) Søk etter arrangement og kategori // (6) Avslutt: ");
            option = scanner.nextInt();
            switch (option){
                case 1: //Organizer part
                    runOrganizer();
                    break;
                case 2: //Customer part
                    runCustomerPart();
                    break;
                case 3:
                    receiveNewCustomerInput();
                    break;
                case 4:
                    receiveNewOrganizerInput();
                    break;
                case 5:
                    search();
                    break;
                case 6:
                    exit = true;
                    break;
                default:
                    System.out.println("Ikke gyldig valg.");
                    break;
            }
        }
        scanner.close();
    }

    private void search(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("(1) Søk etter arrangementnavn // (2) Søk etter kategori // (3) Tilbake til forsiden ");

        try{
            int option = scanner.nextInt();

            if(option == 1)
                searchForEventName();

            else if(option == 2)
                searchForCategories();
            else if(option == 3){
                userOptions();
            }
            else {
                System.out.println("Skriv inn 1, 2 eller 3!");
                search();
            }
        }
        catch(Exception exc){
            System.out.println("Skriv inn et tall!");
            search();
        }
    }

    private void searchForEventName(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Søk etter arrangement: ");

        String searchStr = scanner.nextLine();

        ArrayList<Event> matches = searchEvents(searchStr);

        if(!matches.isEmpty()){
            System.out.println("Følgende arrangment ble funnet:");
            for (Event evt : matches){
                System.out.println("Arrangment index: " + evt.getEventIndex() + "\nNavn: " + evt.getEventName() +"\nLedige billetter: "+ evt.getTicketAmount());
            }
        } else {
            System.out.println("Fant ingen arrangement, vennligst prøv igjen med andre søkeord.");
            search();
        }
    }

    private void searchForCategories(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Søk etter arrangment i kategori: ");

        String searchStr = scanner.nextLine();

        ArrayList<Event> matches = searchCategory(searchStr);

        if(!matches.isEmpty()){
            System.out.println("Følgende arrangment ble funnet:");
            for (Event evt : matches){
                System.out.println("Arrangment index: " + evt.getEventIndex() + "\nNavn: " + evt.getEventName() +"\nLedige billetter: "+ evt.getTicketAmount());
            }
        }
        else {
            System.out.println("Fant ingen arrangement med dette kategoriet, vennligst prøv igjen med andre søkeord.");
            search();
        }
    }
}