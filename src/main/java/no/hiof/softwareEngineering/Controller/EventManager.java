package no.hiof.softwareEngineering.Controller;

import no.hiof.softwareEngineering.Model.Event;
import no.hiof.softwareEngineering.Model.Location;
import no.hiof.softwareEngineering.Model.Organizer;
import no.hiof.softwareEngineering.Model.Ticket;

import java.time.LocalDate;
import java.util.ArrayList;
import static no.hiof.softwareEngineering.Lists.ListManager.eventList;

public class EventManager {

    public void CreateEvent(String eventName, String category, String description, String date, String city, String street, int ageLimit, int tickets, int eventOwner){

       /* String regex = "^(?:[0-9]{2})?[0-9]{2}-[0-3]?[0-9]-[0-3]?[0-9]$";
        Pattern pattern = Pattern.compile(regex);*/

        Event event = new Event(eventName, category, description, ageLimit, tickets, LocalDate.parse(date), new Location(city, street), createIndex(), eventOwner);
        createTickets(tickets, eventName, event.getAvailableTickets());
        eventList.add(event);
    }

    private int createIndex(){
        int tempIndex = 1;

        for(Event event : eventList){
            if(event == null){
                return 1;
            }
            else{
                tempIndex = event.getEventIndex() + 1;
            }
        }

        return tempIndex;
    }

    private void createTickets(int ticketAmount, String eventName, ArrayList<Ticket> availableTickets){
        for (int i = 1; i < ticketAmount+1; i++){
            Ticket ticket = new Ticket(eventName + i, 200 );
            availableTickets.add(ticket);
        }
    }

    public static void printEventList(){
        for (Event e : eventList){
            System.out.println(e);
        }
    }
}
