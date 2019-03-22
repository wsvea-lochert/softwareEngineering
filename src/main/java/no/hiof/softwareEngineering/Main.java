package no.hiof.softwareEngineering;

import no.hiof.softwareEngineering.Model.Event;
import no.hiof.softwareEngineering.Model.Location;
import java.time.LocalDate;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Event soppturMedKarpe = new Event("Sopptur med Karpe","Musikk", "En fin konsert med bra musikk", 18, 150, LocalDate.of(2019, 06, 19), new Location("Halden", "B R A veien 6d"));

        runApplication();
    }

    public static void runApplication(){

        Scanner selection = new Scanner(System.in);
        int option = 0;

        while(option != 4) {
            System.out.print("(1) Lag nytt event // (2) book billett // (3) Print mine billetter // (4) lukk // Skriv inn valg: ");
            option = selection.nextInt();
            switch (option) {
                case 1:
                    Event.CreateEvent();
                    break;
                case 2:
                    Event.bookTicket();
                    break;
                case 3:
                    Event.printMyTickets();
                    break;
                case 4:
                    break;
                default:
                    System.out.print("Ugyldig valg.");
                    runApplication();
            }
        }
    }
}
