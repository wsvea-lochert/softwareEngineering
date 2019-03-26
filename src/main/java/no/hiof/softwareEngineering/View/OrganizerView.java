package no.hiof.softwareEngineering.View;

import no.hiof.softwareEngineering.Controller.OrganizerDriver;
import no.hiof.softwareEngineering.Model.Event;
import no.hiof.softwareEngineering.Controller.Login;
import no.hiof.softwareEngineering.Model.Organizer;

import java.util.Scanner;

public class OrganizerView {

    public static void runOrganizer() {
        int option = 0;
        Organizer admin = LoginView.userLogin();
        Scanner input = new Scanner(System.in);


        while (option < 5 && admin != null) {
            System.out.print("\n(1) Se mine arrangement // (2) Opprett arrangement // (3)  Tilbake: ");
            option = input.nextInt();
            switch (option){
                case 1:
                    OrganizerDriver.printEventList();
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
