package no.hiof.softwareEngineering;

import java.util.Scanner;

public class Person {

    Scanner input = new Scanner(System.in);

    public String password;
    public String firstName;
    public String lastName;
    public String email;
    public int phoneNo;
    public String confirmpassword;
    public String confirmEmail;


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

    public String inputFirstName(String firstName) {
        System.out.print("Fornavn: ");
        firstName = input.nextLine();

        return checkStringLength(1, 50, firstName);
    }

    public String inputLastName(String lastName) {
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

    public String inputEmail(String email) {
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


    public String inputConfirmEmail(String confirmEmail, String email) {

        boolean isValidString = false;

        System.out.print("Gjenta email adressen: ");
        confirmEmail = input.nextLine();

        //ToDo: while løkka må være feil da den ikke godtar at confirmEmail er det samme som email
        while(!isValidString) {
            if (email == confirmEmail){
                isValidString = true;
            }
            else {
                //TODO: må kunne endre første e-postadresse hvis man har skrevet feil
                System.out.print("Denne adressen matcher ikke. Vennligst gjenta email adressen: ");
                confirmEmail = input.nextLine();
            }
        }
        return confirmEmail;
    }

    //TODO: sjekk for passord

    //TODO: sjekk for telefonnummer

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


    public int getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(int phoneNo) {
        this.phoneNo = phoneNo;
    }
}
