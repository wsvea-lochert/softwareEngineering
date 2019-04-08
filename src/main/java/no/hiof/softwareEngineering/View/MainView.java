package no.hiof.softwareEngineering.View;
import no.hiof.softwareEngineering.Controller.OrganizerDriver;
import java.util.Scanner;
import static no.hiof.softwareEngineering.View.CustomerView.runCustomerPart;
import static no.hiof.softwareEngineering.View.OrganizerView.runOrganizer;

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
                    runOrganizer();
                    break;
                case 2: //Customer part
                    //userLogin(Customer.getCustomerList());
                    runCustomerPart();
                    break;
                case 3:
                    registerAccount(option);
                    break;
                case 4:
                    registerAccount(option);
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

    // ToDo: legge inn diverse sjekker på input. Se hva som ligger på Person
    // ToDo: Sjekk på om mailadressen ligger inne allerede?

    private void registerAccount(int option){
        Scanner input = new Scanner(System.in);

        System.out.print("Epostadresse: ");
        String email = input.nextLine();

        System.out.print("Passord: ");
        String password = input.nextLine();

        if(option == 4){
            System.out.print("Firmanavn: ");
            String companyName = input.nextLine();

            //Register new organizer account
            System.out.print("Organisasjonsnummer: ");
            String orgNumber = input.nextLine();

            OrganizerDriver.createNewOrganizerAccount(orgNumber, companyName, email, password);
        }
        else if (option == 3){
            System.out.print("Fornavn ");
            String firstname = input.nextLine();

            System.out.print("Etternavn: ");
            String lastname = input.nextLine();


            OrganizerDriver.createNewOrganizerAccount(firstname,lastname, email, password);
        }
    }
}