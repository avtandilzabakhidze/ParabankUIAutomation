import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {
    @Test(dataProvider = "loginCredentials")
    public void testLogin(String username, String password) {
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
        loginPage.clickLoginButton();

        Assert.assertTrue(loginPage.getCurrentUrl("https://parabank.parasoft.com/parabank/overview.htm"), "\n URL is incorrect \n");
        Assert.assertTrue(loginPage.displayElement(), "\n Log Out Button is not displayed \n");
    }

    @DataProvider(name = "loginCredentials")
    public Object[][] loginCredentials() {
        return new Object[][]{
                {"one", "two"}
        };
    }
}
