package no.hiof.softwareEngineering.Model;

public class Customer {
    Person person;
    String Email;
    String username;
    String password;

    public Customer(Person person, String email, String username, String password) {
        this.person = person;
        Email = email;
        this.username = username;
        this.password = password;
    }

    public Customer(Person person, String email) {
        this.person = person;
        Email = email;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
