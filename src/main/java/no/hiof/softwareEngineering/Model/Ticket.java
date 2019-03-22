package no.hiof.softwareEngineering.Model;


public class Ticket {
    private String ticketCode;
    private double price;
    private Customer customer;

    public Ticket(String ticketCode, double price) {
        this.ticketCode = ticketCode;
        this.price = price;
    }

    public Ticket(String ticketCode, double price, Customer customer){
        this.ticketCode = ticketCode;
        this.price = price;
        this.customer = customer;
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

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Override
    public String toString() {
        return "    Bilettkode: " + ticketCode + "\n    Pris: " + price + "\n     Billett eier: " + customer.getFirstName() + " " + customer.getLastName() + "\n";
    }
}
