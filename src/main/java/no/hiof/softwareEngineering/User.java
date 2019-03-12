package no.hiof.softwareEngineering;

import java.util.ArrayList;

public class User {
    private String username, password;
    private static ArrayList<User> users = new ArrayList<>();

    public User(String username, String password) {
        this.username = username;
        this.password = password;
        users.add(this);
    }

    public static ArrayList<User> getUsers() {
        return users;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
