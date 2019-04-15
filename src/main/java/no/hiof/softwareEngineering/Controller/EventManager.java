package no.hiof.softwareEngineering.Controller;

import no.hiof.softwareEngineering.Model.Event;
import no.hiof.softwareEngineering.Model.Location;
import no.hiof.softwareEngineering.Model.Organizer;
import no.hiof.softwareEngineering.Model.Ticket;
import java.time.LocalDate;
import java.util.ArrayList;
import static no.hiof.softwareEngineering.Lists.ListManager.*;

public class EventManager {

    public static void createEvent(String eventName, String category, String description, String date, String city, String street, String ageLimit, String tickets, String eventOwner, String price){

       /* String regex = "^(?:[0-9]{2})?[0-9]{2}-[0-3]?[0-9]-[0-3]?[0-9]$";
        Pattern pattern = Pattern.compile(regex);*/

        Event event = new Event(eventName, category, description, ageLimit, tickets, LocalDate.parse(date), new Location(city, street), createIndex(), eventOwner);
        createTickets(tickets, eventName, availableTickets, price, event.getEventIndex());
        eventList.add(event);
        System.out.println("Event laget.");
    }

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

    public static void createTickets(String ticketAmount, String eventName, ArrayList<Ticket> availableTickets, String price, int eventIndex){
        int tickets = Integer.parseInt(ticketAmount);
        int rightPrice = Integer.parseInt(price);
        for (int i = 1; i < tickets+1; i++){
            Ticket ticket = new Ticket(eventName + i, rightPrice, eventIndex);
            ticket.setStatus(false);
            availableTickets.add(ticket);
        }
    }

    public static void printEventList(Organizer organizer){
        for (Event e : eventList){
            if (e.getEventOwner().equals(organizer.getCompanyName()))
            System.out.println(e);
        }
    }

    public static void printTotalPrice(int ticketAmount, Event selectedEvent){
        for (Ticket ticket : availableTickets){
            if(ticket.getEventIndexforTickets() == selectedEvent.getEventIndex()){
                System.out.println("Total pris: " + ticket.getPrice()*ticketAmount + ",- \n");
                break;
            }
        }
    }

    public static void printMyTickets(String email){
        for (Ticket ticket : soldTickets){
            if (ticket.getCustomerEmail().equals(email)){
                System.out.println(ticket);
            }
        }
    }

    public static void controllTicket(String code, Organizer organizer){
        for (Event event : eventList){
            for (Ticket ticket : soldTickets){
                if (ticket.getTicketCode().equals(code) && ticket.getEventIndexforTickets() == event.getEventIndex() && event.getEventOwner().equals(organizer.getCompanyName())){
                    if (ticket.isStatus()){
                        System.out.println("Billetten har blitt brukt.");
                    }
                    else{
                        System.out.println("Billetten har ikke blitt brukt.");
                    }
                }
                else{
                    System.out.println("Noe gikk galt, du er enten ikke arrangøren for dette eller billettkoden er feil");
                }
            }
        }
    }

}
