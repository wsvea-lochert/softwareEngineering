package no.hiof.softwareEngineering.Model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Event {
    private String eventName;
    private String category;
    private String description;
    private int ageLimit;
    private int ticketAmount;
    private LocalDate date;
    private Location eventLocation;
    private int eventIndex;

    private ArrayList<Ticket> availableTickets = new ArrayList<>();
    private ArrayList<Ticket> soldTickets = new ArrayList<>();
    private static ArrayList<Event> eventList = new ArrayList<>();

    public Event(String eventName, String category, String description, int ageLimit, int ticketAmount, LocalDate date, Location eventLocation) {
        this.eventName = eventName;
        this.category = category;
        this.description = description;
        this.ageLimit = ageLimit;
        this.ticketAmount = ticketAmount;
        this.date = date;
        this.eventLocation = eventLocation;
        this.eventIndex = createIndex();

        createTickets();
        eventList.add(this);
    }

    public Event() {
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


        String regex = "^(?:[0-9]{2})?[0-9]{2}-[0-3]?[0-9]-[0-3]?[0-9]$";
        Pattern pattern = Pattern.compile(regex);

        System.out.print("Event navn: ");
        String eventName = userInput.nextLine();
        System.out.print("Kategori: ");
        String category = userInput.nextLine();
        System.out.print("Beskrivelse: ");
        String description = userInput.nextLine();

        System.out.print("Dato(YYYY-MM-DD): ");
        String date = userInput.nextLine();
        Matcher matcher = pattern.matcher(date);

        while(!matcher.matches()){
            System.out.print("Ugyldig input skriv inn på nytt: ");
            date = userInput.nextLine();
            matcher = pattern.matcher(date);
        }


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

    private static Event findEvent(int eventToLookFor){
        for (Event event : eventList){
            if (eventToLookFor == event.getEventIndex()){
                return event;
            }
        }
        System.out.println("Event ikke funnet.");
        bookTicket();
        return null;
    }

    private static void PrintEventWithIndex(){
        for (Event event : eventList){
            System.out.println("(" + event.getEventIndex() + ") " + event);
        }
    }

    public static void bookTicket(){
        Event dummy = null;
        ArrayList<Ticket> deleteList = new ArrayList<>();
        Scanner userInput = new Scanner(System.in);
        Scanner userInputString = new Scanner(System.in);

        PrintEventWithIndex();

        System.out.print("Velg event: ");
        int selection = userInput.nextInt();

        dummy = findEvent(selection);

        System.out.print("Velg antall billetter: ");
        int ticketSelected = userInput.nextInt();

        while(ticketSelected > dummy.ticketAmount && ticketSelected <= 0){
            System.out.println("Du har valgt for mange billetter eller ingen billetter.");
            System.out.print("Velgt antall billetter: ");
            ticketSelected = userInput.nextInt();
        }

        Customer customer = Login.userLogin(Customer.getCustomerList());

        dummy.ticketAmount = dummy.ticketAmount - ticketSelected;

        for (Event event : eventList){
            for (Ticket ticket : event.availableTickets){
                if (event.equals(dummy)){
                    ticket.setCustomer(customer);
                    event.soldTickets.add(ticket);
                    deleteList.add(ticket);
                    ticketSelected--;
                }
            }
        }

        for (Event event : eventList){
            if (dummy.equals(event)){
                event.availableTickets.removeAll(deleteList);
            }
        }
    }

    public static void printMyTickets(){
        Scanner userInput = new Scanner(System.in);
        System.out.print("Email som ble brukt til å booke: ");
        String email = userInput.nextLine();

        for (Event event : eventList){
            for (Ticket ticket : event.soldTickets){
                if (ticket.getCustomer().getEmail().equals(email)){
                    System.out.println(ticket);
                }
            }
        }
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

    public int getEventIndex() {
        return eventIndex;
    }

    public void setEventIndex(int eventIndex) {
        this.eventIndex = eventIndex;
    }

    public ArrayList<Ticket> getAvailableTickets() {
        return availableTickets;
    }

    public void setAvailableTickets(ArrayList<Ticket> availableTickets) {
        this.availableTickets = availableTickets;
    }

    public ArrayList<Ticket> getSoldTickets() {
        return soldTickets;
    }

    public void setSoldTickets(ArrayList<Ticket> soldTickets) {
        this.soldTickets = soldTickets;
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
