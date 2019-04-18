package no.hiof.softwareEngineering;

import no.hiof.softwareEngineering.Controller.NewUserAccount;
import no.hiof.softwareEngineering.Lists.ListManager;
import no.hiof.softwareEngineering.Model.Customer;

import no.hiof.softwareEngineering.Model.Organizer;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.Assert;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static no.hiof.softwareEngineering.Controller.NewUserAccount.createNewCustomerAccount;
import static no.hiof.softwareEngineering.Controller.NewUserAccount.createNewOrganizerAccount;
import static no.hiof.softwareEngineering.Lists.ListManager.customerList;
import static no.hiof.softwareEngineering.Lists.ListManager.organizerList;


public class NewUserAccountTest {

    /* 5. Tests for NewUserAccount class */

    private Customer customer;
    private Organizer organizer;

    @BeforeEach
    public void setUp(){
        this.customer = new Customer("Enis", "Jasharaj", "enisj@hiof.no", "enisABC123");
        this.organizer = new Organizer("Juicy J AS", "enisj@hiof.no", "Jasharaj", "Enis", "enisABC123");
    }

    @AfterEach
    public void tearDown(){
        customerList.clear();
        organizerList.clear();
    }



    /* 5A - Validating string length */

    @ParameterizedTest
    @ValueSource(strings = {"Test", "T", "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"})
    public void checkStringLengthTestReturnsTrue(String checkString) {
        boolean result = NewUserAccount.checkStringLength(1, 50, checkString);
        Assertions.assertTrue(result);
    }

    /* 5B - Checking string length fails correctly */

    @ParameterizedTest
    @ValueSource(strings = {"", "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"})
    public void checkStringLengthTestReturnsFalse(String checkString) {
        boolean result = NewUserAccount.checkStringLength(1, 50, checkString);
        Assertions.assertFalse(result);
    }

    /* 5C - Validating emails */

    @ParameterizedTest
    @ValueSource(strings = {"test@epost.abcd", "a@b.cd"})
    public void checkEmailTestReturnsTrue(String checkString) {
        boolean result = NewUserAccount.checkEmail(checkString);
        Assertions.assertTrue(result);
    }

    /* 5D - Email validation fails correctly */

    @ParameterizedTest
    @ValueSource(strings = {"test", "test@epost", "", "test.no", "tøst@æøå.øø", "test@epost.n", "test@epost.abcde", "@.no"})
    public void checkEmailTestReturnsFalse(String checkString) {
        boolean result = NewUserAccount.checkEmail(checkString);
        Assertions.assertFalse(result);
    }

    /* 5E - Validating passwords  */

    @ParameterizedTest
    @ValueSource(strings = {"abcABC1!", "!ABCDabc", "1aB2cD3eF", "123%&/dD"})
    public void checkPasswordTestReturnsTrue(String checkString) {
        boolean result = NewUserAccount.checkPassword(checkString);
        Assertions.assertTrue(result);
    }

    /* 5F - Password validation fails correctly */

    @ParameterizedTest
    @ValueSource(strings = {"abABC1!", "aaaaaaaaaa", "aaaaAAAAAA", "1111!!!!!!!", "aaaaaaa1111111", "AAAAAAA!!!!!!!"})
    public void checkPasswordTestReturnsFalse(String checkString) {
        boolean result = NewUserAccount.checkPassword(checkString);
        Assertions.assertFalse(result);
    }

    /* 5G - Check if customer is added to list */

    @Test
    public void checkIfUserIsAddedToList(){
        createNewCustomerAccount(customer);
        Assertions.assertEquals(customerList.get(0), customer);
    }

    /* 5H - Check if organizer is added to list */

    @Test
    public void checkIfOrganizerIsAddedToList(){
        createNewOrganizerAccount(organizer);
        Assertions.assertEquals(organizerList.get(0), organizer);
    }

    /* 5J - Check if returns true if new user does not already exists*/

    @Test
    public void checkIfCustomerExistsTestReturnsTrue() {
        boolean result = NewUserAccount.checkIfCustomerExists("uniqueemail@unique.cool");
        Assertions.assertTrue(result);
    }

    @Test
    public void checkIfOrganizerExistsTestReturnsTrue() {
        boolean result = NewUserAccount.checkIfOrganizerExists("uniqueemail@unique.cool");
        Assertions.assertTrue(result);
    }

    /* 5J - Check if returns false if new user already exists*/

    @Test
    public void checkIfCustomerExistsTestReturnsFalse() {
        customerList.add(customer);
        boolean result = NewUserAccount.checkIfCustomerExists("enisj@hiof.no");
        Assertions.assertFalse(result);
    }

    @Test
    public void checkIfOrganizerExistsTestReturnsFalse() {
        organizerList.add(organizer);
        boolean result = NewUserAccount.checkIfOrganizerExists("enisj@hiof.no");
        Assertions.assertFalse(result);
    }

}