package no.hiof.softwareEngineering;

import no.hiof.softwareEngineering.Model.Person;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest {

    @Test
    void checkStringLengthTest() {
        Person test = new Person();
        test.setFirstName("T");
        String result = test.checkStringLength(1, 50, test.getFirstName());

        assertEquals("T", result);
    }

    @Test
    void inputEmailTest() {
    }

    /*@Test
    void inputConfirmEmailTest() {
        Person testperson = new Person("abc123", "Test", "Testesen", "test@epost.com");

        String confirmEmailTestInput = "abc@epost.com";
        testperson.inputConfirmEmail(testperson.getEmail());

        assertEquals(testperson.getEmail(), confirmEmailTestInput);
    }*/
}