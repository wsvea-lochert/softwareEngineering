package no.hiof.softwareEngineering.Controller;

import no.hiof.softwareEngineering.Model.Customer;
import no.hiof.softwareEngineering.Model.Event;
import no.hiof.softwareEngineering.Model.Ticket;
import java.util.ArrayList;
import static no.hiof.softwareEngineering.Lists.ListManager.*;

public class Booking {


    /*
    * Finds event by looking at the event index
    */
    public static Event findEvent(int eventToLookFor){
        for (Event event : eventList){
            if (eventToLookFor == event.getEventIndex()){
                return event;
            }
        }
        System.out.println("Event ikke funnet.");
        return null;
    }

    /*
    * prints event with their index for easy selection for users
    */
    public static void printEventWithIndex(){
        for (Event event : eventList){
            System.out.println(event);
            for (Ticket ticket : availableTickets){
                if (ticket.getEventIndexforTickets() == event.getEventIndex()){
                    System.out.println("Billett pris: " + ticket.getPrice() + "\n");
                    break;
                }
            }
        }
    }

    /*
    * Marks tickets with the customers email and moves the ticket(s) from availableTickets to soldTickets
    */
    public static void bookTicket(Event selectedEvent, Customer customer, int ticketSelected){
        ArrayList<Ticket> deleteList = new ArrayList<>();

        if (customer != null){
            selectedEvent.setTicketAmount(selectedEvent.getTicketAmount() - ticketSelected);

            for (Event event : eventList){
                for (Ticket ticket : availableTickets){
                    if (event.equals(selectedEvent) && ticketSelected != 0 && ticket.getEventIndexforTickets() == event.getEventIndex()){
                        ticket.setCustomerEmail(customer.getEmail());
                        deleteList.add(ticket);
                        soldTickets.add(ticket);
                        ticketSelected--;
                    }
                }
            }
            removeSoldTickets(deleteList); //refactor
        }
        else{
            System.out.println("Noe gikk galt.");
        }
    }

    /*
    * Removes tickets from availableTickets list
    */
    public static void removeSoldTickets(ArrayList<Ticket> deleteList){
        availableTickets.removeAll(deleteList);
    }

}
