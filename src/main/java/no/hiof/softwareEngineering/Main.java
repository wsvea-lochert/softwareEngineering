package no.hiof.softwareEngineering;

import no.hiof.softwareEngineering.Model.Customer;
import no.hiof.softwareEngineering.Model.Event;
import no.hiof.softwareEngineering.Model.Location;
import no.hiof.softwareEngineering.Model.Login;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Event test = new Event("asd", "asd", "asd", 2, 200, LocalDate.of(2019, 02,01), new Location("Halden", "asd"));

        Customer testBruker = new Customer("admin", "admin", "admin", "admin");
        //Login.loginOptions();

        Event.bookTicket();
        Event.printMyTickets();

        Login.loginOptions();

    }
}
