package no.hiof.softwareEngineering.View;

import no.hiof.softwareEngineering.Model.Customer;
import no.hiof.softwareEngineering.Model.Event;
import java.util.Scanner;
import static no.hiof.softwareEngineering.Controller.Booking.*;
import static no.hiof.softwareEngineering.Controller.EventManager.printMyTickets;


public class CustomerView {
    static Scanner input = new Scanner(System.in);

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
                    break;
                case 2:
                    book(customer);
                    break;
                case 3:
                    printMyTicketsInput();
                    break;
                case 4:
                    break;
                default:
                    break;
            }
        }
    }

    public static void book(Customer customer){
        Event selectedEvent = null;
        printEventWithIndex();

        System.out.print("Velg event: ");
        int selection = input.nextInt();
        selectedEvent = findEvent(selection);

        System.out.print("Velg antall billetter: ");
        int ticketSelected = input.nextInt();

        while(ticketSelected > selectedEvent.getTicketAmount() && ticketSelected <= 0){
            System.out.println("Du har valgt for mange billetter eller ingen billetter.");
            System.out.print("Velgt antall billetter: ");
            ticketSelected = input.nextInt();
        }
        bookTicket(selectedEvent, customer, ticketSelected);
    }

    public static void printMyTicketsInput(){
        //input.close();
        Scanner inpt = new Scanner(System.in);
        System.out.print("Email som ble brukt til å booke: ");
        String email = inpt.nextLine();

        printMyTickets(email);
    }
}
