import no.hiof.softwareEngineering.ClassToCheckIfTestingWorks;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class FirstTest {

    private ClassToCheckIfTestingWorks bmi;

    @Before
    public void setUp(){ this.bmi = new ClassToCheckIfTestingWorks(1.97,99); }

    @Test
    public void calculateBmiWrongly(){
        Assert.assertEquals(26, bmi.calculateBmi());
    }

    @Test
    public void calculateBmiCorrectly(){ Assert.assertEquals(25, bmi.calculateBmi()); }
}
