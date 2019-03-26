package no.hiof.softwareEngineering.View;

import no.hiof.softwareEngineering.Model.Customer;
import no.hiof.softwareEngineering.Model.Event;

import java.util.Scanner;

import static no.hiof.softwareEngineering.Controller.Booking.*;

public class CustomerView {
    static Scanner input = new Scanner(System.in);

    public static void book(Customer customer){
        Event selectedEvent = null;
        PrintEventWithIndex();

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
