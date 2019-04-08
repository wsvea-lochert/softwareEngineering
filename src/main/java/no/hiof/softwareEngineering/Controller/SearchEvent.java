package no.hiof.softwareEngineering.Controller;

import no.hiof.softwareEngineering.Model.Event;
import static no.hiof.softwareEngineering.Lists.ListManager.eventList;
import java.util.ArrayList;
import java.util.stream.Collectors;

public abstract class SearchEvent {

    public static ArrayList<Event> searchEvents(String searchStr){
        ArrayList<Event> matches = (ArrayList<Event>) eventList.stream().filter(x -> (x.getEventName().toLowerCase().contains(searchStr.toLowerCase()))).collect(Collectors.toList());
        return matches;
    }

    public static ArrayList<Event> searchCategory(String categoryStr){
        ArrayList<Event> matches = (ArrayList<Event>) eventList.stream().filter(x -> (x.getCategory().toLowerCase().contains(categoryStr.toLowerCase()))).collect(Collectors.toList());
        return matches;
    }
}
