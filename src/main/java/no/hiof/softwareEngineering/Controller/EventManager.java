package no.hiof.softwareEngineering.Controller;

import no.hiof.softwareEngineering.Model.Event;
import no.hiof.softwareEngineering.Model.Location;
import no.hiof.softwareEngineering.Model.Organizer;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;

public class EventManager {

    public static ArrayList<Event> eventList = new ArrayList<>();

    public void CreateEvent(Organizer organizer, String eventName, String category, String description, String date, String city, String street, int ageLimit, int tickets, int eventOwner){
        Scanner userInput = new Scanner(System.in);

       /* String regex = "^(?:[0-9]{2})?[0-9]{2}-[0-3]?[0-9]-[0-3]?[0-9]$";
        Pattern pattern = Pattern.compile(regex);*/

        Event event = new Event(eventName, category, description, ageLimit, tickets, LocalDate.parse(date), new Location(city, street), createIndex(), organizer.getOrgNo());
        eventList.add(event);


       // assignEventToOrganizer(event, organizer);
    }

    private int createIndex(){
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

    private static void assignEventToOrganizer(Event event, Organizer organizer){
        for (Organizer org : Organizer.getOrganizerList()){
            if (organizer.equals(org)){
                org.addEvent(event);
            }
        }
    }

    public static void printEventList(){
        for (Event e : eventList){
            System.out.println(e);
        }
    }
}
