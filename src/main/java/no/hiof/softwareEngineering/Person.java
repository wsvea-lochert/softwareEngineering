package no.hiof.softwareEngineering;

import java.util.Scanner;

public abstract class Person {

    Scanner input = new Scanner(System.in);


    public String password;
    public String firstName;
    public String lastName;
    public String email;
    public String phoneNo;
    public String confirmpassword;
    public String confirmEmail;


    public Person() {
    }

    public Person(String userName, String password, String firstName, String lastName, String email) {
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
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


    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
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
                System.out.println("Sett inn et gyldig navn");
                isString = false;
                firstName = input.nextLine();
            }
        }
        while (!(isString));
        return firstName;
    }


}
