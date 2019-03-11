package no.hiof.softwareEngineering;

public class Login {

    public boolean checkFields(String username, String password){
       User user = users.stream().filter( x -> users.contains(username) && users.contains(password))
                .findAny()
                .orElse(null);

       if(user.isNull())
           return false;

       return true;

    }
}


