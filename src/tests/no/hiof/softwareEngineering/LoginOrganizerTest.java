package no.hiof.softwareEngineering;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;

import org.junit.Test;
import org.junit.contrib.java.lang.system.TextFromStandardInputStream;
import static org.junit.contrib.java.lang.system.TextFromStandardInputStream.emptyStandardInputStream;

public class LoginOrganizerTest {
    private Organizer organizer;

    @Rule
    public final TextFromStandardInputStream mockUserInput = emptyStandardInputStream();

    @Before
    public void setUp(){
        this.organizer = new Organizer("enis123", "Enis", "Jasharaj", "enisj@hiof.no", 1234, "Juicy J AS", 1234);
        Organizer.getOrganizerList().add(organizer);
    }

    @Test
    public void checkOrganizerLogin(){
        mockUserInput.provideLines("enisj@hiof.no", "enis123");
        Assert.assertEquals(organizer, Login.organizerLogin());
    }
}