package no.hiof.softwareEngineering;

import no.hiof.softwareEngineering.Model.Customer;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static no.hiof.softwareEngineering.Controller.Login.userValidation;
import static no.hiof.softwareEngineering.Lists.ListManager.customerList;

public class LoginCustomerTest {

    private Customer customer;

    @BeforeEach
    public void setUp(){
        customer = new Customer("Enis", "Jasharaj", "enisj@hiof.no", "enis123");
        customerList.add(customer);
    }

    @AfterEach
    public void tearDown(){
        customerList.clear();
    }

    @Test
    public void checkIfUserLoginReturnsObjectIfFounnd(){
        Assertions.assertEquals(customer, userValidation("enisj@hiof.no", "enis123"));
    }

    @Test
    public void checkIfUserLoginReturnsNullWhenNotFound(){
        Assertions.assertNull(userValidation("ikknoesomskalmatche", "ikkenoe"));
    }
}