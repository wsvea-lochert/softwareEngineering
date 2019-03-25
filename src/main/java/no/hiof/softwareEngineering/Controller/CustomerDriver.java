package no.hiof.softwareEngineering.Controller;

import no.hiof.softwareEngineering.Model.Event;

import java.util.Scanner;

public class CustomerDriver {
    public static void runCustomerPart() {
        int option = 0;
        Scanner input = new Scanner(System.in);

        while (option < 4) {
            System.out.print("\n(1) Se alle eventer // (2) Bestill billett // (3) Se mine billetter // (4)  Tilbake: ");
            option = input.nextInt();
            switch (option) {
                case 1:
                    Event.printEventList();
                    break;
                case 2:
                    Event.bookTicket();
                    break;
                case 3:
                    Event.printMyTickets();
                    break;
                case 4:
                    //System.exit(0);
                    break;
                default:
                    break;
            }
        }
    }
}
