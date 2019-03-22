package no.hiof.softwareEngineering;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;

import org.junit.Test;
import org.junit.contrib.java.lang.system.TextFromStandardInputStream;
import static org.junit.contrib.java.lang.system.TextFromStandardInputStream.emptyStandardInputStream;

public class LoginCustomerTest {
    private Customer customer;

    @Rule
    public final TextFromStandardInputStream mockUserInput = emptyStandardInputStream();

    @Before
    public void setUp(){
        this.customer = new Customer();
        Customer.getCustomerList().add(customer);
    }

    @Test
    public void checkOrganizerLogin(){
        mockUserInput.provideLines();
        Assert.assertEquals(customer, Login.organizerLogin());
    }
}