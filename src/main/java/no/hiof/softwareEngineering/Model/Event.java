package no.hiof.softwareEngineering.Model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Event {
    private String eventName;
    private String category;
    private String description;
    private int ageLimit;
    private int ticketAmount;
    private LocalDate date;
    private Location eventLocation;

    private ArrayList<Ticket> availableTickets = new ArrayList<>();
    ArrayList<Ticket> soldTickets = new ArrayList<>();
    static ArrayList<Event> eventList = new ArrayList<>();

    public Event(String eventName, String category, String description, int ageLimit, int ticketAmount, LocalDate date, Location eventLocation) {
        this.eventName = eventName;
        this.category = category;
        this.description = description;
        this.ageLimit = ageLimit;
        this.ticketAmount = ticketAmount;
        this.date = date;
        this.eventLocation = eventLocation;

        createTickets();
        eventList.add(this);
    }

    private void createTickets(){
        for (int i = 1; i < ticketAmount+1; i++){
            Ticket ticket = new Ticket(eventName + i, 200 );
            availableTickets.add(ticket);
        }
    }

    public void printAvailableTickets(){
        for (Ticket t : availableTickets){
            System.out.println(t + "\n");
        }
    }

    public static void printEventList(){
        for (Event e : eventList){
            System.out.println(e);
        }
    }

    public static void CreateEvent(){
        Scanner userInput = new Scanner(System.in);

        System.out.print("Event navn: ");
        String eventName = userInput.nextLine();
        System.out.print("Kategori: ");
        String category = userInput.nextLine();
        System.out.print("Beskrivelse: ");
        String description = userInput.nextLine();

        System.out.print("Dato(YYYY-MM-DD): ");
        String date = userInput.nextLine();

        System.out.print("By: ");
        String city = userInput.nextLine();
        System.out.print("Gate: ");
        String street = userInput.nextLine();

        System.out.print("Aldersgrense: ");
        int ageLimit = userInput.nextInt();
        System.out.print("Antall billetter: ");
        int tickets = userInput.nextInt();



        Event event = new Event(eventName, category, description, ageLimit, tickets, LocalDate.parse(date), new Location(city, street));
        System.out.println(eventName + " er nå laget.");
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getAgeLimit() {
        return ageLimit;
    }

    public void setAgeLimit(int ageLimit) {
        this.ageLimit = ageLimit;
    }

    public int getTicketAmount() {
        return ticketAmount;
    }

    public void setTicketAmount(int ticketAmount) {
        this.ticketAmount = ticketAmount;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Location getEventLocation() {
        return eventLocation;
    }

    public void setEventLocation(Location eventLocation) {
        this.eventLocation = eventLocation;
    }



    @Override
    public String toString() {
        return "==========================================\n    Navn: " + eventName
                + "\n    kategori: " + category + "\n    Beskrivelse: "
                + description + "\n    Aldersgrense: " + ageLimit + "\n    Ledige biletter: "
                + ticketAmount + "\n    Dato: " + date.getDayOfMonth() + "." + date.getMonthValue()
                + "." + date.getYear() + "\n    Sted: " + eventLocation.getCity() + ", " + eventLocation.getStreet()
                + "\n==========================================";
    }
}
