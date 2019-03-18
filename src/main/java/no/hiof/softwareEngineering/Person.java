package no.hiof.softwareEngineering;

import java.util.Scanner;

public abstract class Person {

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

    public String inputFirstName(String firstName) {
    boolean isString;
        System.out.print("Fornavn: ");
        firstName = input.nextLine();
        do {
            if (firstName.length() > 1 && firstName.length() < 50) {
                isString = true;
                return firstName;
            } else {
                System.out.println("Fornavnet kan maksimalt være på 50 tegn. Vennligst registrer fornavnet på nytt: ");
                isString = false;
                firstName = input.nextLine();
            }
        }
        while (!(isString));
        return firstName;
    }

    public String inputLastName(String lastName) {
        boolean isString;
        System.out.print("Etternavn: ");
        lastName = input.nextLine();
        do {
            if (lastName.length() > 1 && lastName.length() < 50) {
                isString = true;
                return lastName;
            } else {
                System.out.println("Etternavnet kan maksimalt være på 50 tegn. Vennligst registrer etternavnet på nytt");
                isString = false;
                lastName = input.nextLine();
            }
        }
        while (!(isString));
        return lastName;
    }

    public String inputEmail(String email) {
        boolean isString;
        //String regexEmail = "^[-0-9a-zA-Z.+_]+@[-0-9a-zA-Z.+_]+\\.[a-zA-Z]{2,4}";
        String regexEmail = "^[-0-9a-zA-Z.+_]{5}+@[-0-9a-zA-Z.+_]+\\.[a-zA-Z]{2,4}";
        System.out.print("Email: ");
        email = input.nextLine();

        do {
            if (email.matches(regexEmail)){
                isString = true;
                return email ;

            } else {
                isString = false;
                System.out.println("Email adressen var ikke gyldig. Vennligs registrer email adressen på nytt:  ");
                email = input.nextLine();
            }
        }
        while (!(isString));
        return email;
    }

    public String inputConfirmEmail(String confirmEmail, String email) {
        boolean isString;

        System.out.print("Gjenta email adressen: ");
        confirmEmail = input.nextLine();

        do {
            if (email == confirmEmail){
                isString = true;
                return confirmEmail ;

            } else {
                isString = false;
                System.out.print("Denne adressen matcher ikke. Vennligst gjenta email adressen: ");
                confirmEmail = input.nextLine();

            }
        }
        while (!(isString));
        return confirmEmail;
    }


}
