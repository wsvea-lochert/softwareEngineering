package no.hiof.softwareEngineering.View;

import no.hiof.softwareEngineering.Model.Customer;
import no.hiof.softwareEngineering.Model.Event;

import java.util.Scanner;

import static no.hiof.softwareEngineering.Controller.Booking.*;

public class CustomerView {

    public static void runCustomerPart() {
        int option = 0;
        Customer customer = LoginView.customerLogin();

        Scanner input = new Scanner(System.in);

        while (option < 4) {
            System.out.print("\n(1) Se alle eventer // (2) Bestill billett // (3) Se mine billetter // (4)  Tilbake: ");
            option = input.nextInt();
            switch (option) {
                case 1:
                    printEventWithIndex();
                    //Event.printEventList();
                    break;
                case 2:
                    book(customer);
                    //book()
                    break;
                case 3:
                    printMyTickets(customer.getEmail());
                    // Event.printMyTickets();
                    break;
                case 4:
                    //System.exit(0);
                    break;
                default:
                    break;
            }
        }
    }

    static Scanner input = new Scanner(System.in);

    public static void book(Customer customer){
        Event selectedEvent = null;
        printEventWithIndex();

        System.out.print("Velg event: ");
        int selection = input.nextInt();

        System.out.print("Velg antall billetter: ");
        int ticketSelected = input.nextInt();

        selectedEvent = findEvent(selection);

        while(ticketSelected > selectedEvent.getTicketAmount() && ticketSelected <= 0){
            System.out.println("Du har valgt for mange billetter eller ingen billetter.");
            System.out.print("Velgt antall billetter: ");
            ticketSelected = input.nextInt();
        }

    }

    public static void printMyTicketsInput(){
        System.out.print("Email som ble brukt til å booke: ");
        String email = input.nextLine();

        printMyTickets(email);
    }

}
