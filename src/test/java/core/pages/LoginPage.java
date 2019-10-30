package core.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Страница логина
 * https://vk.com/
 */
public class LoginPage extends BasePage {
    private static final By LOGIN_PAGE = By.id("index_login");
    private static final By PHONE_EMAIL = By.id("index_email");
    private static final By PASSWORD = By.id("index_pass");
    private static final By LOGIN_BUTTON = By.id("index_login_button");

    public LoginPage(WebDriver driver) {
        super(driver);
        checkMainElementIsLoaded(LOGIN_PAGE);
    }

    /**
     * @param number   номер телефона
     * @param password пароль
     * @return HomePage()
     */
    public HomePage loginInVk(String number, String password) {
        driver.findElement(PHONE_EMAIL).sendKeys(number);
        driver.findElement(PASSWORD).sendKeys(password);
        driver.findElement(LOGIN_BUTTON).click();
        return new HomePage(driver);
    }
}
