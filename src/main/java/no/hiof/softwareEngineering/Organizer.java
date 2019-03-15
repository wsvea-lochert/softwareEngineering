package no.hiof.softwareEngineering;

public class Organizer extends Person {

    private String companyName;
    private int orgNo;
    private String invoiceChannel; //How to send the invoice  email / post
    private String invoiceStreetAdress;
    private int invoiceZipCode;
    private String invoicePlace;


    //static ArrayList<Event> eventList = new ArrayList<>();

    public Organizer (){
        super();
    }

    public Organizer(String userName, String password, String firstName, String lastName, String email, String phoneNo,String companyName, int orgnr, String invoiceChannel) {
        super(userName, password, firstName, lastName, email, phoneNo);
        this.companyName = companyName;
        this.orgNo = orgnr;
        this.invoiceChannel = invoiceChannel;
       // eventList.add(this);
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public int getOrgNo() {
        return orgNo;
    }

    public void setOrgNo(int orgNo) {
        this.orgNo = orgNo;
    }

    public String getInvoiceChannel() {
        return invoiceChannel;
    }

    public void setInvoiceChannel(String invoiceChannel) {
        this.invoiceChannel = invoiceChannel;
    }

    public String getInvoiceStreetAdress() {
        return invoiceStreetAdress;
    }

    public void setInvoiceStreetAdress(String invoiceStreetAdress) {
        this.invoiceStreetAdress = invoiceStreetAdress;
    }

    public int getInvoiceZipCode() {
        return invoiceZipCode;
    }

    public void setInvoiceZipCode(int invoiceZipCode) {
        this.invoiceZipCode = invoiceZipCode;
    }

    public String getInvoicePlace() {
        return invoicePlace;
    }

    public void setInvoicePlace(String invoicePlace) {
        this.invoicePlace = invoicePlace;
    }
}
