package no.hiof.softwareEngineering.Lists;

import no.hiof.softwareEngineering.Model.Event;
import no.hiof.softwareEngineering.Model.Ticket;
import no.hiof.softwareEngineering.Model.Organizer;

import java.util.ArrayList;

public class ListManager {
    public static ArrayList<Event> eventList = new ArrayList<>();

    public static ArrayList<Ticket> soldTickets = new ArrayList<>();

    public static ArrayList<Organizer> organizerList = new ArrayList<>();
}
