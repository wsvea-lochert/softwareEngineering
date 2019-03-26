package no.hiof.softwareEngineering.Model;

import no.hiof.softwareEngineering.Controller.Login;

import java.time.LocalDate;
import java.util.ArrayList;

public class Event {
    private String eventName;
    private String category;
    private String description;
    private int ageLimit;
    private int ticketAmount;
    private LocalDate date;
    private Location eventLocation;
    private int eventIndex;
    private int eventOwner;

    private ArrayList<Ticket> availableTickets = new ArrayList<>();


    public Event(String eventName, String category, String description, int ageLimit, int ticketAmount, LocalDate date, Location eventLocation, int eventIndex, int eventOwner) {
        this.eventName = eventName;
        this.category = category;
        this.description = description;
        this.ageLimit = ageLimit;
        this.ticketAmount = ticketAmount;
        this.date = date;
        this.eventLocation = eventLocation;
        this.eventIndex = eventIndex;
        this.eventOwner = eventOwner;
    }

    public Event() {
    }


    public int getEventIndex() {
        return eventIndex;
    }

    public ArrayList<Ticket> getAvailableTickets() {
        return availableTickets;
    }

    public String getEventName() {
        return eventName;
    }

    public String getCategory() {
        return category;
    }

    public String getDescription() {
        return description;
    }

    public int getAgeLimit() {
        return ageLimit;
    }

    public int getTicketAmount() {
        return ticketAmount;
    }

    public LocalDate getDate() {
        return date;
    }

    public Location getEventLocation() {
        return eventLocation;
    }

    public int getEventOwner() {
        return eventOwner;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setAgeLimit(int ageLimit) {
        this.ageLimit = ageLimit;
    }

    public void setTicketAmount(int ticketAmount) {
        this.ticketAmount = ticketAmount;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setEventLocation(Location eventLocation) {
        this.eventLocation = eventLocation;
    }

    public void setEventIndex(int eventIndex) {
        this.eventIndex = eventIndex;
    }

    public void setEventOwner(int eventOwner) {
        this.eventOwner = eventOwner;
    }

    public void setAvailableTickets(ArrayList<Ticket> availableTickets) {
        this.availableTickets = availableTickets;
    }

    @Override
    public String toString() {
        return    "========= " + "Arrangement nummer " + eventIndex + " =========\n    Navn: " + eventName
                + "\n    kategori: " + category + "\n    Beskrivelse: "
                + description + "\n    Aldersgrense: " + ageLimit + "\n    Ledige biletter: "
                + ticketAmount + "\n    Dato: " + date.getDayOfMonth() + "." + date.getMonthValue()
                + "." + date.getYear() + "\n    Sted: " + eventLocation.getCity() + ", " + eventLocation.getStreet()
                + "\n==========================================";
    }
}
