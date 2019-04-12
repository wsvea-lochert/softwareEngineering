package no.hiof.softwareEngineering;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static no.hiof.softwareEngineering.Controller.Payment.*;

public class PaymentTest {

    @Test
    public void checkIfCardNumberValidationWorks(){
        Assertions.assertTrue(checkCardNumber("1234123412341234"));
    }

    @Test
    public void checkIfFixDateFormatterForCardPaymentWorks(){
        Assertions.assertEquals("01-04-19", fixDate("04/19"));
    }

    @Test
    public void checkIfDatePatternForPaymentCardWorks(){
        Assertions.assertTrue(checkDatePattern("11/19"));
    }

    @ParameterizedTest
    @ValueSource(ints = {100, 999})
    public void checkIfCVCMethodsWorks(int cvc){
        Assertions.assertTrue(checkCVC(cvc));
    }

    @Test
    public void checkIfDateCheckMethodWorks(){
        Assertions.assertTrue(checkDate("01-11-19"));
    }
}
