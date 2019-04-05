package no.hiof.softwareEngineering;

import no.hiof.softwareEngineering.Controller.Login;
import no.hiof.softwareEngineering.Model.*;
import no.hiof.softwareEngineering.View.MainView;

import java.time.LocalDate;

import static no.hiof.softwareEngineering.Controller.EventManager.createEvent;
import static no.hiof.softwareEngineering.Lists.ListManager.*;

public class Main {

    public static void main(String[] args) {
        //Event TestEvent = new Event("Sopptur med Grete", "Friluft", "Ta med riktige klær og godt humør", 0, 20, LocalDate.of(2019, 03,29), new Location("Halden", "B R A veien 6d"), 1, "admin");
        createEvent("Sopptur med Grete", "Friluft", "Ta med riktige klær og godt humør", "2019-03-29", "Halden", "BRA veien 6d", 0, 200, "admin");
        Customer testCustomer = new Customer("bruker", "bruker", "bruker", "bruker");
        Organizer TestOrganizer = new Organizer("admin", "admin", "admin", "admin");
        organizerList.add(TestOrganizer);
        //eventList.add(TestEvent);
        customerList.add(testCustomer);

        MainView run = new MainView();
        run.userOptions();
    }
}
