package no.hiof.softwareEngineering;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import static no.hiof.softwareEngineering.Controller.EventManager.*;
import static no.hiof.softwareEngineering.Lists.ListManager.availableTickets;
import static no.hiof.softwareEngineering.Lists.ListManager.eventList;

public class EventManagerTest {

    @BeforeEach
    public void setUp(){
        createEvent("Sopptur med Grete", "Friluft", "Ta med riktige klær og godt humør",
                "2019-03-29", "Halden", "BRA veien 6d", "0", "0", "admin");

        createEvent("Biltur med Johnny", "Friluft", "Koselig biltur",
                "2019-04-24", "Oslo", "Karrestadveien 12", "18", "0", "admin");

        createTickets("200", "Biltur med Johnny", availableTickets);

    }

    @AfterEach
    public void tearDown(){
        eventList.clear();
        availableTickets.clear();
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
        Assertions.assertEquals(200, availableTickets.size());
    }

}
