package no.hiof.softwareEngineering.Model;

import java.time.LocalDate;


public class Event {
    private String eventName;
    private String category;
    private String description;
    private String ageLimit;
    private String ticketAmount;
    private LocalDate date;
    private Location eventLocation;
    private int eventIndex;
    private String eventOwner;


    public Event(String eventName, String category, String description, String ageLimit, String ticketAmount, LocalDate date, Location eventLocation, int eventIndex, String eventOwner) {
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

    public String getEventName() {
        return eventName;
    }

    public String getCategory() {
        return category;
    }

    public String getDescription() {
        return description;
    }

    public String getAgeLimit() {
        return ageLimit;
    }

    public int getTicketAmount() {
        return Integer.parseInt( ticketAmount );
    }

    public LocalDate getDate() {
        return date;
    }

    public Location getEventLocation() {
        return eventLocation;
    }

    public String getEventOwner() {
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

    public void setAgeLimit(String ageLimit) {
        this.ageLimit = ageLimit;
    }

    public void setTicketAmount(int ticketAmount) {
        this.ticketAmount = String.valueOf( ticketAmount );
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

    public void setEventOwner(String eventOwner) {
        this.eventOwner = eventOwner;
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
