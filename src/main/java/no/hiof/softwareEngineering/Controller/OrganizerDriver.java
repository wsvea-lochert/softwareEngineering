package no.hiof.softwareEngineering.Controller;

import no.hiof.softwareEngineering.Model.Customer;
import no.hiof.softwareEngineering.Model.Organizer;
import static no.hiof.softwareEngineering.Lists.ListManager.organizerList;
import static no.hiof.softwareEngineering.Lists.ListManager.eventList;

public class OrganizerDriver{

    //ToDo: Det vil komme flere felt relatert til Person
    public static void createNewOrganizerAccount(String orgNo, String companyName, String email, String password) {
        Organizer organizer = new Organizer(orgNo, companyName, email, password);
        organizerList.add(organizer);
    }

    public static void createNewOrganizerAccount(Organizer organizer) {

        organizerList.add(organizer);
        System.out.println("Din arrangørkonto er opprettet!");
    }

    public void printEventList(){
        System.out.println(eventList);
    }



}
