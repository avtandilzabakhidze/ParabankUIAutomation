import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {
    @Test(dataProvider = "successLoginCredentials", priority = 1)
    public void testCorrectCredentials(String username, String password) {
        loginSteps.login(username, password);
        loginSteps.verifySuccessfulLogin();
    }

    @Test( priority = 2)
    public void testIncorrectUsername() {
        loginSteps.login("1", "two");
        loginSteps.verifyIncorrectCredentials();
    }

    @Test( priority = 3)
    public void testIncorrectPassword() {
        loginSteps.login("one", "2");
        loginSteps.verifyIncorrectCredentials();
    }

    @Test( priority = 4)
    public void testEmptyPassword() {
        loginSteps.login("one", "");
        loginSteps.verifyEmptyCredentials();
    }

    @Test( priority = 4)
    public void testEmptyUsername() {
        loginSteps.login("", "two");
        loginSteps.verifyEmptyCredentials();
    }

    @DataProvider(name = "successLoginCredentials")
    public Object[][] loginCredentials() {
        return new Object[][]{
                {"one", "two"}
        };
    }
}
