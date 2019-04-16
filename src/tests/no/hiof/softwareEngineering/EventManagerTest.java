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

    /* 2. Tests for EventManagerClass  */

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

    /* 2A - Marking tickets as used */

    @Test
    public void checkIfMarkTicketMethodWorks(){
        markTicketAsUsed("Sopptur1", organizer);
        Assertions.assertTrue(soldTickets.get(0).isStatus());
    }

    /* 2B - Creating events */

    @Test
    public void checkIfEventIsAddedToListWhenCreateEventMethodIsCalled(){
        Assertions.assertEquals(eventList.size(), 2);
    }

    /* 2C - Unique ID for events */

    @Test
    public void checkIfCreateIndexWorks(){
       Assertions.assertEquals(createIndex(), 3);
    }

    /* 2D - Creating tickets */

    @Test
    public void checkIfCreateTicketsWorks(){
        Assertions.assertEquals(198, availableTickets.size());
    }

    /* 2E - Ticket controll - failing correctly */

    @Test
    public void checkIfTicketControlFailsCorrectly(){
        Assertions.assertFalse(controllTicket("Sopptur2", organizer));
    }

    /* 2F - Ticket controll - working correctly */

    @Test
    public void checkIfTicketControlWorks(){
        markTicketAsUsed("Sopptur1", organizer);
        Assertions.assertTrue(controllTicket("Sopptur1", organizer));
    }

    /* 2G - Showing data about my events */
    @Test
    public void checkIfEventStatisticsWorks(){
        Assertions.assertEquals(eventList.get(0), returnMyEvents(organizer).get(0));
    }

}
