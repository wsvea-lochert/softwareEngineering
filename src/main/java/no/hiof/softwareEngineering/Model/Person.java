package no.hiof.softwareEngineering.Model;

import java.util.Scanner;

public class Person {

    Scanner input = new Scanner(System.in);

    private String password;
    private String firstName;
    private String lastName;
    private String email;
    private int phoneNo;
    private String confirmpassword;
    private String confirmEmail;


    public Person() {
    }

    public Person(String password, String firstName, String lastName, String email) {
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public Person(String password, String firstName, String lastName, String email, int phoneNo) {
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNo = phoneNo;
    }

    public String inputFirstName() {
        System.out.print("Fornavn: ");
        firstName = input.nextLine();

        return checkStringLength(1, 50, firstName);
    }

    public String inputLastName() {
        System.out.print("Etternavn: ");
        lastName = input.nextLine();

        return checkStringLength(1, 50, lastName);
    }

    public String checkStringLength(int minlength, int maxlength, String inputstring) {
        boolean isValidString = false;

        while(!isValidString){
            if (inputstring.length() >= minlength && inputstring.length() <= maxlength){
                isValidString = true;
            }
            else{
                System.out.println("Feil i input. Vennligst prøv igjen (max " + maxlength + " tegn): ");
                inputstring = input.nextLine();
            }
        }
        return inputstring;
    }

    public String inputEmail() {
        boolean isValidString = false;
        //ToDo: fikse regex uttrykket - matcher bare hvis to tegn før @
        //String regexEmail = "^[-0-9a-zA-Z.+_]{2}+@[-0-9a-zA-Z.+_]+\\.[a-zA-Z]{2,4}";
        String regexEmail = "^[-0-9a-zA-Z.+_]+@[-0-9a-zA-Z.+_]+\\.[a-zA-Z]{2,4}";
        System.out.print("Email: ");
        email = input.nextLine();

        while(!isValidString) {
            if (email.matches(regexEmail)){
                isValidString = true;
            }
            else {
                System.out.println("Email adressen var ikke gyldig. Vennligst registrer email adressen på nytt:");
                email = input.nextLine();
            }
        }
        return email;
    }


    public String inputConfirmEmail(String email) {

        boolean isValidString = false;

        System.out.print("Gjenta email adressen: ");
        confirmEmail = input.nextLine();

        //ToDo: while løkka må være feil da den ikke godtar at confirmEmail er det samme som email
        while(!isValidString) {
            if (!email.equals(confirmEmail)){
                //TODO: må kunne endre første e-postadresse hvis man har skrevet feil
                System.out.print("Denne adressen matcher ikke. Vennligst gjenta email adressen: ");
                confirmEmail = input.nextLine();
            }
            else {
                isValidString = true;
            }
        }
        return confirmEmail;
    }

    //sjekk for passord
    //TODO: funker bare når bokstaver, tall og spes.tegn er i spesifikk rekkefølge, fiks
    public String inputPassword() {
        boolean isValidString = false;

        //regex hentet fra: https://riptutorial.com/regex/example/18996/a-password-containing-at-least-1-uppercase--1-lowercase--1-digit--1-special-character-and-have-a-length-of-at-least-of-10
        String uppercase = "(?=.*[A-Z])";
        String lowercase = "(?=.*[A-Z])";
        String numbers = "(?=.*[0-9])";
        String specChar = "(?=.*\\W)";

        System.out.print("Ønsket passord (må inneholde min 8 tegn, store og små bokstaver og tall og/eller spesialtegn): ");
        password = input.nextLine();

        while(!isValidString) {
            if (password.length() < 8) {
                System.out.println("Passordet må inneholde minst 8 tegn.");
                password = input.nextLine();

                if (!password.contains(uppercase) || !password.contains(lowercase)){
                    System.out.println("Passordet må inneholde store og små bokstaver.");
                    password = input.nextLine();
                }
                else if (!password.contains(numbers) && !password.contains(specChar)){
                    System.out.println("Passordet må inneholde tall og/eller spesialtegn.");
                    password = input.nextLine();
                }
            }
            else {
                isValidString = true;

            }
        }
        return password;
    }

    public String confirmPassword(String password) {
        System.out.print("Gjenta passord: ");
        confirmpassword = input.nextLine();

        boolean isValidString = false;

        while(!isValidString){
            if (!confirmpassword.equals(password)){
                //TODO: må kunne endre tidligere utfylt passord hvis skrevet feil?
                System.out.println("Passordet er ikke det samme som i forrige felt.");
                confirmpassword = input.nextLine();
            }
            else {
                isValidString = true;
            }
        }
        return confirmpassword;
    }

    //sjekk for telefonnummer
    public int inputPhonenumber(){
        System.out.print("Telefonnummer (8 siffer): ");
        String phoneNo = input.nextLine();

        String numberRegex = "(^[0-9]{8}$)";

        boolean isValidString = false;

        while(!isValidString){
            if(!phoneNo.matches(numberRegex)){
                System.out.println("Telefonnummeret er ikke gyldig.");
                phoneNo = input.nextLine();
            }
            else {
                isValidString = true;
            }
        }
        return Integer.parseInt(phoneNo);
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getConfirmEmail() {
        return confirmEmail;
    }

    public void setConfirmEmail(String confirmEmail) {
        this.confirmEmail = confirmEmail;
    }

    public String getConfirmpassword() {
        return confirmpassword;
    }

    public void setConfirmpassword(String confirmpassword) {
        this.confirmpassword = confirmpassword;
    }


    public int getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(int phoneNo) {
        this.phoneNo = phoneNo;
    }
}
