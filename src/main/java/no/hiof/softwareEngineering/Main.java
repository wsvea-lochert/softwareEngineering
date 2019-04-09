package no.hiof.softwareEngineering;

import java.time.LocalDate;

import no.hiof.softwareEngineering.Model.*;
import no.hiof.softwareEngineering.View.MainView;
import no.hiof.softwareEngineering.View.NewUserView;
import static no.hiof.softwareEngineering.Controller.EventManager.createEvent;
import static no.hiof.softwareEngineering.Lists.ListManager.*;
import static no.hiof.softwareEngineering.View.PaymentView.runPayment;

public class Main {

    public static void main(String[] args) {

        /*createEvent("Sopptur med Grete", "Friluft", "Ta med riktige klær og godt humør", "2019-03-29", "Halden", "BRA veien 6d", 0, 200, "admin");
        Customer testCustomer = new Customer("bruker", "bruker", "bruker@bruker.com", "brukerABC123");
        Organizer TestOrganizer = new Organizer("admin", "admin@admin.no", "adminABC123", "admin", "admin");
        organizerList.add(TestOrganizer);
        customerList.add(testCustomer);*/
        runPayment();
        MainView run = new MainView();
        run.userOptions();
    }
}
