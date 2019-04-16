package no.hiof.softwareEngineering;

import no.hiof.softwareEngineering.Model.Customer;
import no.hiof.softwareEngineering.Model.Organizer;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import static no.hiof.softwareEngineering.Controller.Booking.bookTicket;
import static no.hiof.softwareEngineering.Controller.EventManager.*;
import static no.hiof.softwareEngineering.Lists.ListManager.*;

public class EventManagerTest {
    private Organizer organizer;

    @BeforeEach
    public void setUp(){
        organizer = new Organizer("Juicy", "enisj@hiof.no", "enisJ123", "Enis", "Skåksrud");
        Customer customer = new Customer("Enis", "Jasharaj", "enisj@hiof.no", "enis123");

        createEvent("Sopptur", "Friluft", "Ta med riktige klær og godt humør",
                "2019-10-20", "Halden", "BRA veien 6d", "0", "0", "Juicy", "144");

        createEvent("Biltur", "Friluft", "Koselig biltur",
                "2019-10-20", "Oslo", "Karrestadveien 12", "18", "0", "Juicy", "200");

        createTickets("200", "Sopptur", availableTickets, "200", 1);

        bookTicket(eventList.get(0), customer, 2);
    }

    @AfterEach
    public void tearDown(){
        eventList.clear();
        availableTickets.clear();
        soldTickets.clear();
    }

    @Test
    public void checkIfMarkTicketMethodWorks(){
        markTicketAsUsed("Sopptur1", organizer);
        Assertions.assertTrue(soldTickets.get(0).isStatus());
    }

    @Test
    public void checkIfEventIsAddedToListWhenCreateEventMethodIsCalled(){
        Assertions.assertEquals(eventList.size(), 2);
    }

    @Test
    public void checkIfCreateIndexWorks(){
       Assertions.assertEquals(createIndex(), 3);
    }

    @Test
    public void checkIfCreateTicketsWorks(){
        Assertions.assertEquals(198, availableTickets.size());
    }

    @Test
    public void checkIfTicketControlFailsCorrectly(){
        Assertions.assertFalse(controllTicket("Sopptur2", organizer));
    }

    @Test
    public void checkIfTicketControlWorks(){
        markTicketAsUsed("Sopptur1", organizer);
        Assertions.assertTrue(controllTicket("Sopptur1", organizer));
    }

}
