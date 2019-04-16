package no.hiof.softwareEngineering;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import java.util.ArrayList;

import no.hiof.softwareEngineering.Model.Event;
import no.hiof.softwareEngineering.Model.Location;

import static no.hiof.softwareEngineering.Controller.SearchEvent.searchEvents;
import static no.hiof.softwareEngineering.Controller.SearchEvent.searchCategory;

import static no.hiof.softwareEngineering.Lists.ListManager.eventList;


public class SearchEventTest {


    /* 7. Tests for SearchEvent class */

    private ArrayList<Event> emptyDummyArray = new ArrayList<>();

    @BeforeEach
    public void setUp(){
        eventList.add(new Event("Sopptur med Grete", "Friluft",
                                    "Ta med riktige klær og godt humør",
                "0", "200",
                                    LocalDate.parse("2019-03-29"), new Location("Halden", "BRA veien 6d"), 21,
                                    "admin"));

        eventList.add(new Event("Halden Marathon", "Friluft",
                                "50 kilometer med ren glede!",
                                "16", "1000", LocalDate.parse("2019-03-29"),
                                new Location("Halden", "BRA veien 6d"), 22,
                                "admin"));
    }

    @AfterEach
    public void tearDown(){
        eventList.clear();
    }

    /* 7A - Check if an array of Event objects are returned */

    @Test
    public void checkIfSearchEventByEventNameReturnsArrayOfEventObjects(){
        Assertions.assertEquals(eventList.get(0), searchEvents("sopptur").get(0));
    }

    /* 7B - Check if empty array is returned when no matches are found */

    @Test
    public void checkIfSearchEventByEventNameReturnsEmptyArrayIfNoMatches(){
        Assertions.assertEquals(emptyDummyArray, searchEvents("ikkenoesomskalmatchenoesomhelst"));
    }

    /* 7C - Check if an array of Event objects are returned when searching for categories */

    @Test
    public void checkIfSearchEventByCategoryNameReturnsArrayOfEventObjects(){
        Assertions.assertEquals(eventList, searchCategory("friluft"));
    }

    /* 7D - Check if empty array is returned when no matches are found when searching for categories */

    @Test
    public void checkIfSearchEventByCategoryReturnsEmptyArrayIfNoMatches(){
        Assertions.assertEquals(emptyDummyArray, searchCategory("ikkenoesomskalmatchenoesomhelst"));
    }
}