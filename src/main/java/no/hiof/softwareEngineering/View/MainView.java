package no.hiof.softwareEngineering.View;
import no.hiof.softwareEngineering.Controller.CustomerDriver;
import no.hiof.softwareEngineering.Controller.OrganizerDriver;
import no.hiof.softwareEngineering.Model.Customer;

import java.util.Scanner;

public class MainView {

    public void userOptions(){
        Scanner scanner = new Scanner(System.in);
        int option = 0;

        while(option < 5){
            System.out.print("\n(1) Arrangør seksjon // (2) Kunde seksjon // (3) Registrer kunde konto // (4) Registrer ny arrangør // (5) Avslutt: ");
            option = scanner.nextInt();
            switch (option){
                case 1: //Organizer part
                    // userLogin(Organizer.getOrganizerList());
                    OrganizerView.runOrganizer();
                    break;
                case 2: //Customer part
                    //userLogin(Customer.getCustomerList());
                    CustomerDriver.runCustomerPart();
                    break;
                case 3:
                    Customer.createAccount();
                    break;
                case 4:
                    registerOrganizerAccont();
                    break;
                case 5:
                    break;
                default:
                    System.out.println("Ikke gyldig valg.");
                    break;
            }
        }
        scanner.close();
    }

    private void registerOrganizerAccont(){
        Scanner input = new Scanner(System.in);

        //gyldig orgnr er 9 siffer
        System.out.print("Firmanavn: ");
        String companyName = input.nextLine();

        //Register new organizer account
        System.out.print("Organisasjonsnummer: ");
        String orgNumber = input.nextLine();

        System.out.print("Epostadresse: ");
        String email = input.nextLine();

        System.out.print("Passord: ");
        String password = input.nextLine();

        OrganizerDriver.createNewOrganizerAccount(orgNumber, companyName, email, password);
    }

}