package no.hiof.softwareEngineering.Lists;

import no.hiof.softwareEngineering.Model.Customer;
import no.hiof.softwareEngineering.Model.Event;
import no.hiof.softwareEngineering.Model.Ticket;
import no.hiof.softwareEngineering.Model.Organizer;
import java.util.ArrayList;

public class ListManager {

    public static ArrayList<Event> eventList = new ArrayList<>(); // a list that holds all events in the system
    public static ArrayList<Ticket> soldTickets = new ArrayList<>(); // a list that holds all sold tickets
    public static ArrayList<Organizer> organizerList = new ArrayList<>(); // a list that holds all organizers in the system
    public static ArrayList<Customer> customerList = new ArrayList<>(); // a list that holds all customers in the system
    public static ArrayList<Ticket> availableTickets = new ArrayList<>(); // a list that holds all unsold tickets that can be bought

}
