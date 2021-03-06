package no.hiof.softwareEngineering;

import no.hiof.softwareEngineering.Model.Organizer;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static no.hiof.softwareEngineering.Controller.Login.organizerValidation;
import static no.hiof.softwareEngineering.Lists.ListManager.organizerList;

public class LoginOrganizerTest {

    /* 4. Tests for Login class */

    private Organizer organizer;

    @BeforeEach
    public void setUp(){
        organizer = new Organizer("MS AS", "martinos@hiof.no", "martin123", "Martin", "Skåksrud");
        organizerList.add(organizer);
    }

    @AfterEach
    public void tearDown(){
        organizerList.clear();
    }

    /* 4A - Returning the correct object */

    @Test
    public void checkIfOrganizerLoginReturnsObjectIfFound(){
        Assertions.assertEquals(organizer, organizerValidation("martinos@hiof.no", "martin123"));
    }

    /* 4B - Returning null if no object is found */

    @Test
    public void checkIfOrganizerLoginReturnsNullWhenNotFound(){
        Assertions.assertNull(organizerValidation("ikknoesomskalmatche", "ikkenoe"));
    }
}
