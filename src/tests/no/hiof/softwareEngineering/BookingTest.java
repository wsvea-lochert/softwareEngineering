package no.hiof.softwareEngineering;

import no.hiof.softwareEngineering.Model.Customer;
import no.hiof.softwareEngineering.Model.Ticket;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static no.hiof.softwareEngineering.Controller.Booking.*;
import static no.hiof.softwareEngineering.Controller.EventManager.createEvent;
import static no.hiof.softwareEngineering.Lists.ListManager.*;

public class BookingTest {

    private Customer customer;
    private ArrayList<Ticket> deleteList = new ArrayList<>();

    @BeforeEach
    public void setUp(){
        createEvent("Sopptur med Grete", "Friluft", "Ta med riktige klær og godt humør",
                "2019-03-29", "Halden", "BRA veien 6d", 0, 10, "admin");

        customer = new Customer("Enis", "Jasharaj", "enisj@hiof.no", "enis123");
    }

    @AfterEach
    public void tearDown(){
        eventList.clear();
        availableTickets.clear();
        soldTickets.clear();
    }

    @Test
    public void checkIfFindEventWorks(){
        Assertions.assertEquals(eventList.get(0), findEvent(1));
    }

    @Test
    public void checkIfTicketAmmountDecreasesProperly(){
        bookTicket(eventList.get(0), customer, 2);
        Assertions.assertEquals(8, eventList.get(0).getTicketAmount());
    }

    @Test
    public void checkIfTicketsAreRemovedFromAvailableTicketsList(){
        deleteList.add(0, availableTickets.get(3));
        removeSoldTickets(eventList.get(0), deleteList);

        Assertions.assertEquals(9, availableTickets.size());
    }

    @Test
    public void checkIfTicketIsAddedToSoldTicketsListWhenPaymentIsAccepted(){
        bookTicket(eventList.get(0), customer, 2);
        Assertions.assertEquals(2, soldTickets.size());
    }


}
