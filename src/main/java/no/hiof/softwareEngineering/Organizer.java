package no.hiof.softwareEngineering;

import java.util.Scanner;

public class Organizer extends Person {

    private String companyName;
    private int orgNo;

    public Organizer(){ }

    public Organizer(String password, String firstName, String lastName, String email, String phoneNo,String companyName, int orgnr) {
        super(password, firstName, lastName, email, phoneNo);
        this.companyName = companyName;
        this.orgNo = orgnr;
    }

    public void createNewOrganizerAccount() {
        Scanner input = new Scanner(System.in);

        //Register new organizer account
        System.out.print("Firmanavn: ");
        companyName = input.nextLine();

        System.out.print("Organisasjonsnummer: ");
        orgNo = Integer.parseInt(input.nextLine());

        //System.out.print("Fornavn: ");
        //firstName = input.nextLine();
        firstName = inputFirstName(firstName);

        System.out.print("Etternavn: ");
        lastName = input.nextLine();

        System.out.print("Email: ");
        email = input.nextLine();

        System.out.print("Gjenta email: ");
        confirmEmail = input.nextLine();

        System.out.print("Telefonnummer: ");
        phoneNo = input.nextLine();

        System.out.print("Ønsket passord: ");
        password = input.nextLine();

        System.out.print("Gjenta passord: ");
        confirmpassword = input.nextLine();
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
}
