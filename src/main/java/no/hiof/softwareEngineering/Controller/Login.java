package no.hiof.softwareEngineering.Controller;


import no.hiof.softwareEngineering.Model.Organizer;
import static no.hiof.softwareEngineering.Lists.ListManager.organizerList;

public abstract class Login {
    public static Organizer loginValidation(String email, String password){
        return organizerList.stream().filter(org -> email.equals(org.getEmail()) && password.equals(org.getPassword())).findFirst().orElse(null);
    }

}
