package no.hiof.softwareEngineering;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;


import static no.hiof.softwareEngineering.Controller.Payment.*;

public class PaymentTest {

    /* 6. Tests for Payment class */

    /* 6A - Validating card number */

    @Test
    public void checkIfCardNumberValidationWorks(){
        Assertions.assertTrue(checkCardNumber("1234123412341234"));
    }

    /* 6B - Date formatting */

    @Test
    public void checkIfFixDateFormatterForCardPaymentWorks(){
        Assertions.assertEquals("01-04-19", fixDate("04/19"));
    }

    /* 6C - Making sure the date pattern works */

    @Test
    public void checkIfDatePatternForPaymentCardWorks(){
        Assertions.assertTrue(checkDatePattern("11/19"));
    }

    /* 6D - Validating CVC */

    @ParameterizedTest
    @ValueSource(ints = {100, 999})
    public void checkIfCVCMethodsWorks(int cvc){
        Assertions.assertTrue(checkCVC(cvc));
    }

    /* 6E - Validating date */

    @Test
    public void checkIfDateCheckMethodWorks(){
        Assertions.assertTrue(checkDate("01-11-19"));
    }
}
