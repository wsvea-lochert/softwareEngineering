package no.hiof.softwareEngineering.Model;

import java.util.Scanner;

public abstract class Login {

    public static void loginOptions(){
        System.out.println("Er du en arrangør? Skriv inn '1' for å gå til arrangør-innlogging.\n" +
                "Er du en kunde? Skriv inn '2' for å gå til kunde-innlogging.");
        Scanner scanner = new Scanner(System.in);
        int option = scanner.nextInt();
        while(option <= 2){
            if(option == 1) {
                organizerLogin();
                break;
            } else if(option == 2) {
                customerLogin();
                break;
            }
        }
        scanner.close();
    }

    public static Organizer organizerLogin(){
        System.out.println("Arrangør-innlogging");
        Scanner scanner = new Scanner(System.in);
        Organizer organizer;

        for(int i = 0; i < 3; i++){
            System.out.print("Epost: ");
            String inputEmail = scanner.nextLine();

            System.out.print("Passord: ");
            String inputPassword = scanner.nextLine();

            organizer = organizerValidation(inputEmail, inputPassword);
            if(organizer != null){
                System.out.println("\nDu er nå logget inn.");
                return organizer;
            } else
                System.out.println("Feil epost og/eller passord, vennligst prøv igjen.");
        }

        System.out.println("Alle forsøk er brukt opp, vennligst prøv igjen senere.");
        scanner.close();
        return null;
    }

    public static Organizer organizerValidation(String email, String password){
        return Organizer.getOrganizerList().stream().filter(org -> email.equals(org.getEmail()) && password.equals(org.getPassword())).findAny().orElse(null);
    }


    public static Customer customerLogin(){
        System.out.println("Kunnde-innlogging");
        Scanner scanner = new Scanner(System.in);
        Customer customer;

        for(int i = 0; i < 3; i++){
            System.out.print("Epost: ");
            String inputEmail = scanner.nextLine();

            System.out.print("Passord: ");
            String inputPassword = scanner.nextLine();

            customer = customerValidation(inputEmail, inputPassword);
            if(customer != null){
                System.out.println("Du er nå logget inn.");
                return customer;
            } else
                System.out.println("Feil epost og/eller passord, vennligst prøv igjen.");
        }

        System.out.println("Alle forsøk er brukt opp, vennligst prøv igjen senere.");
        scanner.close();
        return null;
    }

    public static Customer customerValidation(String email, String password){
        return Customer.getCustomerList().stream().filter(cust -> email.equals(cust.getEmail()) && password.equals(cust.getPassword())).findAny().orElse(null);
    }
}
