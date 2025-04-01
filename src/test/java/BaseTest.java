import com.parabank.base.BaseAction;
import com.parabank.steps.LoginSteps;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.IOException;

public class BaseTest {
    WebDriver driver;
    LoginSteps loginSteps;
    BaseAction baseAction;

    @BeforeMethod
    public void setUp() throws IOException {
        baseAction = new BaseAction();
        driver = baseAction.getDriver();
        driver.get(baseAction.getUrl());
        loginSteps = new LoginSteps(driver);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}