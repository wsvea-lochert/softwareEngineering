import no.hiof.softwareEngineering.Login;
import no.hiof.softwareEngineering.User;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static org.junit.contrib.java.lang.system.TextFromStandardInputStream.*;

import org.junit.contrib.java.lang.system.TextFromStandardInputStream;

public class testForUserLogin {
    private User user;

    @Rule
    public final TextFromStandardInputStream mockUserInput = emptyStandardInputStream();

    @Before
    public void setUp(){
        this.user = new User("enisj", "123");
    }

    @Test
    public void checkUserValidation(){
        Assert.assertEquals(user, Login.userValidation("enisj", "123"));
    }

    @Test
    public void checkUserLogin(){
        mockUserInput.provideLines("enisj", "123");
        Assert.assertEquals(user, Login.userLoginIn());
    }
}
