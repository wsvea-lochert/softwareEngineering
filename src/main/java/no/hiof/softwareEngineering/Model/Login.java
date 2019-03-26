package no.hiof.softwareEngineering.Model;

import no.hiof.softwareEngineering.Controller.CustomerDriver;
import no.hiof.softwareEngineering.Controller.OrganizerDriver;

import java.util.ArrayList;
import java.util.Scanner;

public abstract class Login {

    private static Organizer loginValidation(String email, String password){
        return userList.stream().filter(org -> email.equals(org.getEmail()) && password.equals(org.getPassword())).findFirst().orElse(null);
    }

}
