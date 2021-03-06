package no.hiof.softwareEngineering.Controller;

import no.hiof.softwareEngineering.Model.Event;
import no.hiof.softwareEngineering.Model.Location;
import no.hiof.softwareEngineering.Model.Organizer;
import no.hiof.softwareEngineering.Model.Ticket;
import java.time.LocalDate;
import java.util.ArrayList;
import static no.hiof.softwareEngineering.Lists.ListManager.*;

public class EventManager {

    /*
    * Create events for Event manager
    */
    public static void createEvent(String eventName, String category, String description, String date, String city, String street, String ageLimit, String tickets, String eventOwner, String price){
        Event event = new Event(eventName, category, description, ageLimit, tickets, LocalDate.parse(date), new Location(city, street), createIndex(), eventOwner);
        createTickets(tickets, eventName, availableTickets, price, event.getEventIndex());
        eventList.add(event);
        System.out.println("Event laget.");
    }

    /*
    * Create index for a event thats one higher then the last event created
    */
    public static int createIndex(){
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

    /*
    * Create tickets for events
    */
    public static void createTickets(String ticketAmount, String eventName, ArrayList<Ticket> availableTickets, String price, int eventIndex){
        int tickets = Integer.parseInt(ticketAmount);
        int rightPrice = Integer.parseInt(price);
        for (int i = 1; i < tickets+1; i++){
            Ticket ticket = new Ticket(eventName + i, rightPrice, eventIndex, false);
            //ticket.setStatus(false);
            availableTickets.add(ticket);
        }
    }

    public static ArrayList<Event> returnMyEvents(Organizer organizer){
        ArrayList<Event> placeHolder = new ArrayList<>();
        for (Event e : eventList){
            if (e.getEventOwner().equals(organizer.getCompanyName()))
                placeHolder.add(e);
        }

        return placeHolder;
    }

    /*
    * prints the total price of a users booking
    */
    public static void printTotalPrice(int ticketAmount, Event selectedEvent){
        for (Ticket ticket : availableTickets){
            if(ticket.getEventIndexforTickets() == selectedEvent.getEventIndex()){
                System.out.println("Total pris: " + ticket.getPrice()*ticketAmount + ",- \n");
                break;
            }
        }
    }

    /*
    * prints users tickets
    */
    public static void printMyTickets(String email){
        for (Ticket ticket : soldTickets){
            if (ticket.getCustomerEmail().equals(email)){
                System.out.println(ticket);
            }
        }
    }

    /*
    * Controlls the status of a ticket to see if it has been used or not.
    * the organizer has to be the owner of the event to see the status.
    */
    public static boolean controllTicket(String code, Organizer organizer){
        for (Event event : eventList){
            for (Ticket ticket : soldTickets){
                if (ticket.getTicketCode().equals(code) && ticket.getEventIndexforTickets() == event.getEventIndex() && event.getEventOwner().equals(organizer.getCompanyName())){
                    if (ticket.isStatus()){
                        //System.out.println(ticket);
                        System.out.println("Billetten har blitt brukt opp.");
                        return true;
                    }
                    else{
                        //System.out.println(ticket);
                        System.out.println("Billetten har ikke blitt brukt opp.");
                        return false;
                    }
                }
            }
        }
        System.out.println("Du er ikke eier av dette eventet.");
        return false;
    }

    /*
    * The event owner can mark a ticket as used.
    */
    public static void markTicketAsUsed(String code, Organizer organizer){
        for (Event event : eventList){
            for (Ticket ticket : soldTickets){
                if (ticket.getTicketCode().equals(code) && ticket.getEventIndexforTickets() == event.getEventIndex() && event.getEventOwner().equals(organizer.getCompanyName())){
                    ticket.setStatus(true);
                }

            }
        }
    }

}
