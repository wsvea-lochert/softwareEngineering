package no.hiof.softwareEngineering.View;

import no.hiof.softwareEngineering.Model.Organizer;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import static no.hiof.softwareEngineering.Controller.EventManager.*;

public class OrganizerView {
    static Scanner input = new Scanner(System.in);

    public static void runOrganizer() {
        int option = 0;
        Organizer admin = LoginView.userLogin();



        while (option < 5 && admin != null) {
            System.out.print("\n(1) Se mine arrangement // (2) Opprett arrangement // (3)  Tilbake: ");
            option = input.nextInt();
            switch (option){
                case 1:
                   // OrganizerDriver.printEventList();
                    break;
                case 2:
                    createEventInput(admin);
                    break;
                case 3:
                    break;
                default:
                    break;
            }
        }
    }

    public static void createEventInput(Organizer organizer){
        String regex = "^(?:[0-9]{2})?[0-9]{2}-[0-3]?[0-9]-[0-3]?[0-9]$";
        Pattern pattern = Pattern.compile(regex);

        System.out.print("Event navn: ");
        String eventName = input.nextLine();
        System.out.print("Kategori: ");
        String category = input.nextLine();
        System.out.print("Beskrivelse: ");
        String description = input.nextLine();

        System.out.print("Dato(YYYY-MM-DD): ");
        String date = input.nextLine();
        Matcher matcher = pattern.matcher(date);

        while(!matcher.matches()){
            System.out.print("Ugyldig input skriv inn på nytt: ");
            date = input.nextLine();
            matcher = pattern.matcher(date);
        }

        System.out.print("By: ");
        String city = input.nextLine();
        System.out.print("Gate: ");
        String street = input.nextLine();

        System.out.print("Aldersgrense: ");
        int ageLimit = input.nextInt();
        System.out.print("Antall billetter: ");
        int tickets = input.nextInt();

        createEvent(eventName, category, description, date, city, street, ageLimit, tickets, organizer.getOrgNo());
    }

}
