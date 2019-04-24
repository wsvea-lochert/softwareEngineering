package no.hiof.softwareEngineering.Model;


public class Ticket {
    private String ticketCode;
    private double price;
    private String customerEmail;
    private int eventIndexforTickets;
    private boolean status;

    public Ticket(String ticketCode, double price, int eventIndexforTickets, boolean status) {
        this.ticketCode = ticketCode;
        this.price = price;
        this.eventIndexforTickets = eventIndexforTickets;
        this.status = status;
    }


    public String getTicketCode() {
        return ticketCode;
    }

    public void setTicketCode(String ticketCode) {
        this.ticketCode = ticketCode;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public int getEventIndexforTickets() {
        return eventIndexforTickets;
    }

    public void setEventIndexforTickets(int eventIndexforTickets) {
        this.eventIndexforTickets = eventIndexforTickets;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        String ticketStatus;
        if (!status){
            ticketStatus = "ikke brukt";
        }
        else{
            ticketStatus = "brukt";
        }
        return "    Bilettkode: " + ticketCode + "\n    Pris: " + price + "\n    Bruksstatus: " + ticketStatus + "\n";
    }
}

