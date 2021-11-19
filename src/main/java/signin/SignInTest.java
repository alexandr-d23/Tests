package signin;// Generated by Selenium IDE

import common.TestBase;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class SignInTest extends TestBase {

    @Before
    public void before() {
        setup();
    }

    @Test
    public void signIn() {
        getLoginHelper().login(new UserData(
                "d23.alexandr",
                "Test1"
        ));
    }

}
