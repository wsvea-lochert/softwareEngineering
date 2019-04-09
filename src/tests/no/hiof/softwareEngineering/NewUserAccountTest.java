package no.hiof.softwareEngineering;

import no.hiof.softwareEngineering.Model.Customer;
import org.junit.jupiter.api.BeforeEach;

public class NewUserAccountTest {
    @BeforeEach
    public void createTestObject()  {
        Customer testCustomer = new Customer("Test", "Testesen", "test@epost.no", "abcABC123");
    }

}
