package no.hiof.softwareEngineering;

import no.hiof.softwareEngineering.Model.*;
import no.hiof.softwareEngineering.View.MainView;
import static no.hiof.softwareEngineering.Controller.EventManager.createEvent;
import static no.hiof.softwareEngineering.Lists.ListManager.*;

public class Main {

    public static void main(String[] args) {

        createEvent("Sopptur med Grete", "Friluft", "Ta med riktige klær og godt humør", "2019-03-29", "Halden", "BRA veien 6d", 0, 200, "admin");
        Customer testCustomer = new Customer("bruker", "bruker", "bruker", "bruker");
        Organizer TestOrganizer = new Organizer("admin", "admin", "admin", "admin");
        organizerList.add(TestOrganizer);
        customerList.add(testCustomer);

        MainView run = new MainView();
        run.userOptions();
    }
}
