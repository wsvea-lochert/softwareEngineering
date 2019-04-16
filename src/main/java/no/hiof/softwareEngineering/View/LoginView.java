package no.hiof.softwareEngineering.View;

import no.hiof.softwareEngineering.Controller.Login;
import no.hiof.softwareEngineering.Model.Customer;
import no.hiof.softwareEngineering.Model.Organizer;


import java.util.Scanner;

public class LoginView {

    public static Organizer organizerLogin(){
        Scanner scanner = new Scanner(System.in);
        Organizer user;

        for(int i = 0; i < 3; i++){
            System.out.println( "Vennligst logg inn: " );
            System.out.print("Epost: ");
            String inputEmail = scanner.nextLine();

            System.out.print("Passord: ");
            String inputPassword = scanner.nextLine();

            user = Login.organizerValidation(inputEmail, inputPassword);
            if(user != null){
                // System.out.println("\nDu er nå logget inn.");
                return user;
            } else if(i == 2){
                System.out.println("Alle forsøk er brukt opp, vennligst prøv igjen senere.");
                MainView run = new MainView();
                run.userOptions();
            } else {
                System.out.println("Feil epost og/eller passord, vennligst prøv igjen.");
            }
        }

        scanner.close();
        return null;
    }

    public static Customer customerLogin(){
        Scanner scanner = new Scanner(System.in);
        Customer user;

        for(int i = 0; i < 3; i++){
            System.out.println( "Vennligst logg inn: " );
            System.out.print("Epost: ");
            String inputEmail = scanner.nextLine();

            System.out.print("Passord: ");
            String inputPassword = scanner.nextLine();

            user = Login.userValidation(inputEmail, inputPassword);
            if(user != null){
                // System.out.println("\nDu er nå logget inn.");
                return user;
            } else if(i == 2){
                System.out.println("Alle forsøk er brukt opp, vennligst prøv igjen senere.");
                MainView run = new MainView();
                run.userOptions();
            } else {
                System.out.println("Feil epost og/eller passord, vennligst prøv igjen.");
            }
        }

        scanner.close();
        return null;
    }
}
