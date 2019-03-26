package no.hiof.softwareEngineering.Model;


public class Ticket {
    private String ticketCode;
    private double price;
    private String customerEmail;

    public Ticket(String ticketCode, double price) {
        this.ticketCode = ticketCode;
        this.price = price;
    }

    public Ticket(String ticketCode, double price, String customerEmail){
        this.ticketCode = ticketCode;
        this.price = price;
        this.customerEmail = customerEmail;
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

    @Override
    public String toString() {
        return "    Bilettkode: " + ticketCode + "\n    Pris: " + price + "\n";
    }
}
