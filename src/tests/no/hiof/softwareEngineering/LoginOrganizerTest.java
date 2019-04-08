package no.hiof.softwareEngineering;

import no.hiof.softwareEngineering.Model.Organizer;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static no.hiof.softwareEngineering.Controller.Login.organizerValidation;
import static no.hiof.softwareEngineering.Lists.ListManager.organizerList;

public class LoginOrganizerTest {

    private Organizer organizer;

    @BeforeEach
    public void setUp(){
        organizer = new Organizer("MS AS", "martinos@hiof.no", "martin123", "Martin", "Skåksrud");
        organizerList.add(organizer);
    }

    @Test
    public void checkIfOrganizerLoginReturnsObjectIfFound(){
        Assertions.assertEquals(organizer, organizerValidation("martinos@hiof.no", "martin123"));
    }

    @Test
    public void checkIfOrganizerLoginReturnsNullWhenNotFound(){
        Assertions.assertNull(organizerValidation("ikknoesomskalmatche", "ikkenoe"));
    }
}
