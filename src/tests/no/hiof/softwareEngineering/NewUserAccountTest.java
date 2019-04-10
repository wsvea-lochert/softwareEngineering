package no.hiof.softwareEngineering;

import no.hiof.softwareEngineering.Controller.NewUserAccount;
import no.hiof.softwareEngineering.Model.Customer;
import no.hiof.softwareEngineering.Model.Organizer;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;


public class NewUserAccountTest {

    @ParameterizedTest
    @ValueSource(strings = {"Test", "T", "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"})
    public void checkStringLengthTestReturnsTrue(String checkString) {
        boolean result = NewUserAccount.checkStringLength(1, 50, checkString);
        Assert.assertTrue(result);
    }

    @ParameterizedTest
    @ValueSource(strings = {"", "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"})
    public void checkStringLengthTestReturnsFalse(String checkString) {
        boolean result = NewUserAccount.checkStringLength(1, 50, checkString);
        Assert.assertFalse(result);
    }

    @ParameterizedTest
    @ValueSource(strings = {"test@epost.abcd", "a@b.cd"})
    public void checkEmailTestReturnsTrue(String checkString) {
        boolean result = NewUserAccount.checkEmail(checkString);
        Assert.assertTrue(result);
    }

    @ParameterizedTest
    @ValueSource(strings = {"test", "test@epost", "", "test.no", "tøst@æøå.øø", "test@epost.n", "test@epost.abcde", "@.no"})
    public void checkEmailTestReturnsFalse(String checkString) {
        boolean result = NewUserAccount.checkEmail(checkString);
        Assert.assertFalse(result);
    }

    @ParameterizedTest
    @ValueSource(strings = {"abcABC1!", "!ABCDabc", "1aB2cD3eF", "123%&/dD"})
    public void checkPasswordTestReturnsTrue(String checkString) {
        boolean result = NewUserAccount.checkPassword(checkString);
        Assert.assertTrue(result);
    }

    @ParameterizedTest
    @ValueSource(strings = {"abABC1!", "aaaaaaaaaa", "aaaaAAAAAA", "1111!!!!!!!", "aaaaaaa1111111", "AAAAAAA!!!!!!!"})
    public void checkPasswordTestReturnsFalse(String checkString) {
        boolean result = NewUserAccount.checkPassword(checkString);
        Assert.assertFalse(result);
    }

}