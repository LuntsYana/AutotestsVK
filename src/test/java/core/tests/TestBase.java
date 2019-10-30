package core.tests;

import core.pages.LoginPage;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import static core.Constants.*;

public class TestBase {
    protected WebDriver driver;

    @Before
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(SITE_HOME_PAGE);
        new LoginPage(driver).loginInVk(USER_PHONE_NUMBER, USER_PASSWORD);
    }

    @After
    public void after() {
        driver.quit();
    }
}
