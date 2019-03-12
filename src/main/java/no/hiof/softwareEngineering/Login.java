package no.hiof.softwareEngineering;

import java.util.Scanner;

public abstract class Login {

    public static User userLoginIn(){
        Scanner userInput = new Scanner(System.in);
        User user;

        for(int i = 0; i < 3; i++){
            System.out.println("Brukernavn: ");
            String inputUsername = userInput.nextLine();
            System.out.println("Passord: ");
            String inputPassword = userInput.nextLine();

            user = userValidation(inputUsername, inputPassword);
            if(user != null) {
                System.out.println("Du er nå logget inn!");
                return user;
            }
            else
                System.out.println("Feil brukernavn og/eller passord, vennligst prøv igjen");
        }

        System.out.println("Alle forsøk er brukt opp. Vennligst prøv igjen senere.");
        return null;
    }

    public static User userValidation(String username, String password){
        return User.getUsers().stream().filter(x -> username.equals(x.getUsername())
                && password.equals(x.getPassword())).findAny().orElse(null);
    }
}


