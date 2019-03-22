package no.hiof.softwareEngineering;

import no.hiof.softwareEngineering.Model.Customer;
import no.hiof.softwareEngineering.Model.Login;
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
        this.customer = new Customer("enis123", "Enis", "Jasharaj", "enisj@hiof.no");
    }

    @Test
    public void checkCustomerLogin(){
        mockUserInput.provideLines("enisj@hiof.no", "enis123");
        Assert.assertEquals(customer, Login.userLogin(Customer.getCustomerList()));
    }
}