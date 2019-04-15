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
        Organizer admin = LoginView.organizerLogin();

        while (option < 4 && admin != null) {
            System.out.print("\n(1) Se mine arrangement // (2) Opprett arrangement // (3) Kontroller billett // (4)  Tilbake: ");
            option = input.nextInt();
            switch (option){
                case 1:
                    printEventList(admin);
                    break;
                case 2:
                    createEventInput(admin);
                    break;
                case 3:
                    controllTicketInput(admin);
                    break;
                case 4:
                    break;
                default:
                    break;
            }
        }
    }

    private static void createEventInput(Organizer organizer){
        Scanner stringInput = new Scanner(System.in);
        String regex = "^(?:[0-9]{2})?[0-9]{2}-[0-3]?[0-9]-[0-3]?[0-9]$";
        Pattern pattern = Pattern.compile(regex);
        System.out.print("Event navn: ");
        String eventName = stringInput.nextLine();
        while(eventName.isEmpty()) {
            System.out.println( "Ugyldig input skriv inn på nytt: " );
            eventName = stringInput.nextLine();
        }
        System.out.print("Kategori: ");
        String category = stringInput.nextLine();
        while(category.isEmpty()) {
            System.out.println( "Ugyldig input skriv inn på nytt: " );
            category = stringInput.nextLine();
        }
        System.out.print("Beskrivelse: ");
        String description = stringInput.nextLine();
        while(description.isEmpty()) {
            System.out.println( "Ugyldig input skriv inn på nytt: " );
            description = stringInput.nextLine();
        }
        System.out.print("Dato(YYYY-MM-DD): ");
        String date = stringInput.nextLine();
        Matcher matcher = pattern.matcher(date);

        while(!matcher.matches()){
            System.out.print("Ugyldig input skriv inn på nytt: ");
            date = stringInput.nextLine();
            matcher = pattern.matcher(date);
        }

        System.out.print("By: ");
        String city = stringInput.nextLine();
        while(city.isEmpty()) {
            System.out.println( "Ugyldig input skriv inn på nytt: " );
            city = stringInput.nextLine();
        }
        System.out.print("Gate: ");
        String street = stringInput.nextLine();
        while(street.isEmpty()) {
            System.out.println( "Ugyldig input skriv inn på nytt: " );
            street = stringInput.nextLine();
        }

        String regexOnlyNum = "^[0-9]+$";
        Pattern patternOnlyNum = Pattern.compile(regexOnlyNum);
        System.out.print("Aldersgrense: ");
        String ageLimit = stringInput.nextLine();
        Matcher matcherOnlyNum = patternOnlyNum.matcher(ageLimit);

        while(!matcherOnlyNum.matches()){
            System.out.print("Ugyldig input skriv inn på nytt: ");
            ageLimit = stringInput.nextLine();
            matcherOnlyNum = patternOnlyNum.matcher(ageLimit);
        }


        System.out.print("Antall billetter: ");
        String tickets = stringInput.nextLine();
        Matcher matcherOnlyNum2 = patternOnlyNum.matcher(tickets);

        while(!matcherOnlyNum2.matches()){
            System.out.print("Ugyldig input skriv inn på nytt: ");
            tickets = stringInput.nextLine();
            matcherOnlyNum2 = patternOnlyNum.matcher(ageLimit);
        }

        System.out.print("Pris per bilett: ");
        String price = stringInput.nextLine();
        Matcher matcherOnlyNum3 = patternOnlyNum.matcher(ageLimit);

        while(!matcherOnlyNum3.matches()){
            System.out.print("Ugyldig input skriv inn på nytt: ");
            price = stringInput.nextLine();
            matcherOnlyNum3 = patternOnlyNum.matcher(ageLimit);
        }



        createEvent(eventName, category, description, date, city, street, ageLimit, tickets, organizer.getCompanyName(), price);
    }

    private static void controllTicketInput(Organizer organizer){
        Scanner userInput = new Scanner(System.in);
        System.out.print("Billett kode:");
        String ticketCode = userInput.nextLine();
        controllTicket(ticketCode, organizer);
    }

}
