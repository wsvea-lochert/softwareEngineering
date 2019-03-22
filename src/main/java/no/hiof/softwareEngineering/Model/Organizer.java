package no.hiof.softwareEngineering.Model;

import java.util.ArrayList;
import java.util.Scanner;

public class Organizer extends Person {

    private static String companyName;
    private static int orgNo;

    private static ArrayList<Organizer> organizerList = new ArrayList<>();

    public Organizer(){ }

    public Organizer(String password, String firstName, String lastName, String email, int phoneNo,String companyName, int orgnr) {
        super(password, firstName, lastName, email, phoneNo);
        this.companyName = companyName;
        this.orgNo = orgnr;
        organizerList.add(this);
    }

    public void createNewOrganizerAccount() {
        Scanner input = new Scanner(System.in);

        //Register new organizer account
        System.out.print("Firmanavn: ");
        companyName = input.nextLine();

        //gyldig orgnr er 9 siffer
        System.out.print("Organisasjonsnummer: ");
        orgNo = Integer.parseInt(input.nextLine());

        super.setFirstName(inputFirstName());

        super.setLastName(inputLastName());

        super.setEmail(inputEmail());
        //ToDo: må legge inn validering på om email adressen allerede finnes i arrayen

        super.setConfirmEmail(inputConfirmEmail(super.getEmail()));

        super.setPhoneNo(inputPhonenumber());

        super.setPassword(inputPassword());

        super.setConfirmpassword(confirmPassword(super.getPassword()));



        //organizerList.add(new Organizer(password, firstName, lastName, email, phoneNo, companyName, orgNo));
        //Organizer organizer = new Organizer(password, firstName, lastName, email, phoneNo, companyName, orgNo);

        Organizer.printOrganizerList();
    }

    public static void printOrganizerList(){
        for (Organizer organizer : organizerList){
            System.out.println(organizer.getCompanyName() + " " + organizer.getEmail());
        }
    }

    //TODO: sjekk for firmanavn

    //TODO: sjekk for organisasjonsnummer

    public String getCompanyName() {
        return companyName;
    }

    public static ArrayList<Organizer> getOrganizerList() {
        return organizerList;
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
