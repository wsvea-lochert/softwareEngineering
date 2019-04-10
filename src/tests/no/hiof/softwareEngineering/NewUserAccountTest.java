package no.hiof.softwareEngineering;

import no.hiof.softwareEngineering.Controller.NewUserAccount;
import no.hiof.softwareEngineering.Model.Customer;
import no.hiof.softwareEngineering.Model.Organizer;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class NewUserAccountTest {
    private Customer testCustomer;
    private Customer emptyTestCustomer;
    private Customer wrongTestCustomer;
    private Organizer testOrganizer;
    private Organizer emptyTestOrganizer;
    private Organizer wrongTestOrganizer;

    @BeforeEach
    public void createTestObjects()  {
        testCustomer = new Customer("Test", "Testesen", "test@epost.no", "abcABC123");
        emptyTestCustomer = new Customer("", "", "", "");
        wrongTestCustomer = new Customer("Tehfjkuyytrehbgnjmuhgfdcvbnhyujkmnhgfdertghyujkijhu", "Tehfjkuyytrehbgnjmuhgfdcvbnhyujkmnhgfdertghyujkijhu", "test", "abc");
        testOrganizer = new Organizer("Test AS", "test@test.no", "ABCabc123", "Testhild", "Testerius");
        emptyTestOrganizer = new Organizer("", "", "", "", "");
        wrongTestOrganizer = new Organizer("Test AS", "test", "abc", "Tehfjkuyytrehbgnjmuhgfdcvbnhyujkmnhgfdertghyujkijhu", "Tehfjkuyytrehbgnjmuhgfdcvbnhyujkmnhgfdertghyujkijhu");
    }

    @Test
    public void checkStringLengthTest() {
        boolean resultTrue = NewUserAccount.checkStringLength(1, 50, testCustomer.getFirstname());
        Assert.assertTrue(resultTrue);

        boolean resultFalse = NewUserAccount.checkStringLength(1, 50, emptyTestCustomer.getFirstname());
        Assert.assertFalse(resultFalse);
    }

}
