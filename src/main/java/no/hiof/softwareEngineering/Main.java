package no.hiof.softwareEngineering;

import no.hiof.softwareEngineering.Model.*;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Event TestEvent = new Event("Sopptur med Grete", "Friluft", "Ta med riktige klær og godt humør", 0, 20, LocalDate.of(2019, 03,29), new Location("Halden", "B R A veien 6d"));
        Customer testCustomer = new Customer("bruker", "bruker", "bruker", "bruker");
        Organizer TestOrganizer = new Organizer("admin", "admin", "admin", "admin", 00000000, "admin", 110001001);

        Login.loginOptions();
    }
}
