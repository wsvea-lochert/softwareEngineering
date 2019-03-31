package no.hiof.softwareEngineering.Model;

public class Customer {
    private String firstname;
    private String lastname;
    private String email;
    private String password;

    public Customer(String firstname, String lastname, String email, String password) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.password = password;
    }

    // ToDo: Hva med å arve fra Person? Skal vi droppe det?

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}
