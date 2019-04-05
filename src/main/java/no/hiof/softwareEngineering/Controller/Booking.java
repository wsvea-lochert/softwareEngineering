package no.hiof.softwareEngineering.Controller;

import no.hiof.softwareEngineering.Model.Customer;
import no.hiof.softwareEngineering.Model.Event;
import no.hiof.softwareEngineering.Model.Ticket;
import java.util.ArrayList;
import static no.hiof.softwareEngineering.Lists.ListManager.*;

public class Booking {

    public static Event findEvent(int eventToLookFor){
        for (Event event : eventList){
            if (eventToLookFor == event.getEventIndex()){
                return event;
            }
        }
        System.out.println("Event ikke funnet.");
        return null;
    }

    public static void printEventWithIndex(){
        for (Event event : eventList){
            System.out.println(event);
        }
    }

    public static void bookTicket(Event selectedEvent, Customer customer, int ticketSelected){
        ArrayList<Ticket> deleteList = new ArrayList<>();

        if (customer != null){
            selectedEvent.setTicketAmount(selectedEvent.getTicketAmount() - ticketSelected);

            for (Event event : eventList){
                for (Ticket ticket : availableTickets){
                    if (event.equals(selectedEvent) && ticketSelected != 0){
                        ticket.setCustomerEmail(customer.getEmail());
                        deleteList.add(ticket);
                        soldTickets.add(ticket);
                        ticketSelected--;
                    }
                }
            }
            removeSoldTickets(selectedEvent, deleteList); //refactor
        }
        else{
            System.out.println("Noe gikk galt.");
        }
    }

    private static void removeSoldTickets(Event selectedEvent, ArrayList<Ticket> deleteList){
        for (Event event : eventList){
            if (selectedEvent.equals(event)){
                availableTickets.removeAll(deleteList);
            }
        }
    }

}
