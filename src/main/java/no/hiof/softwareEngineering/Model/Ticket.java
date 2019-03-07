package no.hiof.softwareEngineering.Model;


public class Ticket {
    private String ticketCode;
    private double price;

    public Ticket(String ticketCode, double price) {
        this.ticketCode = ticketCode;
        this.price = price;
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

    @Override
    public String toString() {
        return "    Bilettkode: " + ticketCode + "\n    Pris: " + price;
    }
}
