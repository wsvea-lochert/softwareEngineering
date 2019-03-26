package no.hiof.softwareEngineering.Model;

import no.hiof.softwareEngineering.Controller.CustomerDriver;
import no.hiof.softwareEngineering.Controller.OrganizerDriver;

import java.util.ArrayList;
import java.util.Scanner;

public abstract class Login {

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
