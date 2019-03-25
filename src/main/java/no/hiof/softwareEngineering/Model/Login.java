package no.hiof.softwareEngineering.Model;

import no.hiof.softwareEngineering.Controller.CustomerDriver;
import no.hiof.softwareEngineering.Controller.OrganizerDriver;

import java.util.ArrayList;
import java.util.Scanner;

public abstract class Login {

    public static void loginOptions(){
        Scanner scanner = new Scanner(System.in);
        int option = 0;

        while(option < 5){
            System.out.print("\n(1) Arrangør seksjon // (2) Kunde seksjon // (3) Registrer kunde konto // (4) Registrer ny arrangør // (5) Avslutt: ");
            option = scanner.nextInt();
            switch (option){
                case 1: //Organizer part
                   // userLogin(Organizer.getOrganizerList());
                    OrganizerDriver.runOrganizer();
                    break;
                case 2: //Customer part
                    //userLogin(Customer.getCustomerList());
                    CustomerDriver.runCustomerPart();
                    break;
                case 3:
                    Customer.createAccount();
                    break;
                case 4:
                    Organizer.createOrganizer();
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

    public static <T extends Person> T userLogin(ArrayList<T> userList){
        Scanner scanner = new Scanner(System.in);
        T user;

        for(int i = 0; i < 3; i++){
            System.out.print("Epost: ");
            String inputEmail = scanner.nextLine();

            System.out.print("Passord: ");
            String inputPassword = scanner.nextLine();

            user = loginValidation(inputEmail, inputPassword, userList);
            if(user != null){
               // System.out.println("\nDu er nå logget inn.");
                return user;
            } else
                System.out.println("Feil epost og/eller passord, vennligst prøv igjen.");
        }

        System.out.println("Alle forsøk er brukt opp, vennligst prøv igjen senere.");
        scanner.close();
        return null;
    }

    private static <T extends Person> T loginValidation(String email, String password, ArrayList<T> userList){
        return userList.stream().filter(org -> email.equals(org.getEmail()) && password.equals(org.getPassword())).findFirst().orElse(null);
    }

}
