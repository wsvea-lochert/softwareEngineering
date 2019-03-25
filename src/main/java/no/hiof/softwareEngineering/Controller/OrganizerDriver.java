package no.hiof.softwareEngineering.Controller;

import no.hiof.softwareEngineering.Model.Event;
import no.hiof.softwareEngineering.Model.Login;
import no.hiof.softwareEngineering.Model.Organizer;
import java.util.Scanner;

public class OrganizerDriver {
    public static void runOrganizer() {
        int option = 0;
        Scanner input = new Scanner(System.in);
        Organizer admin = Login.userLogin(Organizer.getOrganizerList());

        while (option < 5 && admin != null) {
            System.out.print("\n(1) Se mine arrangement // (2) Opprett arrangement // (3)  Tilbake: ");
            option = input.nextInt();
            switch (option) {
                case 1:
                    admin.printEventList();
                    break;
                case 2:
                    Event.CreateEvent(admin);
                    break;
                case 3:
                    break;
                default:
                    break;
            }
        }
    }
}
