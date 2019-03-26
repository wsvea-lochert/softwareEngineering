package no.hiof.softwareEngineering.View;

import no.hiof.softwareEngineering.Controller.Login;
import no.hiof.softwareEngineering.Model.Organizer;


import java.util.Scanner;

public class LoginView {

    public static Organizer userLogin(){
        Scanner scanner = new Scanner(System.in);
        Organizer user;

        for(int i = 0; i < 3; i++){
            System.out.print("Epost: ");
            String inputEmail = scanner.nextLine();

            System.out.print("Passord: ");
            String inputPassword = scanner.nextLine();

            user = Login.loginValidation(inputEmail, inputPassword);
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
}
