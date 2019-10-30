package core.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static core.Constants.DELETE_FROM_BOOKMARKS;

/**
 * Личная страница пользователя
 */
public class UserPage extends BasePage {
    private static final By ACTION_BUTTON = By.className("page_extra_actions_btn");
    private static final By ADD_IN_BOOKMARKS = By.xpath("//a[contains(@onclick, 'Profile.toggleFave')]");
    private static final By ACTION_BAR_MENU = By.className("page_actions_header");
    private static final By USER_NAME = By.className("page_name");

    public UserPage(WebDriver driver) {
        super(driver);
    }

    /**
     * Добавляет в закладки
     */
    public void addInBookmarks() {
        driver.findElement(ACTION_BUTTON).click();
        driver.findElement(ADD_IN_BOOKMARKS).click();
    }

    /**
     * Проверяет, если пользователь уже в закладках, то удаляет его из закладок
     *
     * @return UserPage()
     */
    public UserPage deleteUserFromBookmarks() {
        driver.findElement(ACTION_BUTTON).click();
        WebElement addButton = driver.findElement(ADD_IN_BOOKMARKS);
        if (addButton.getText().contentEquals(DELETE_FROM_BOOKMARKS)) {
            addButton.click();
        }
        driver.findElement(ACTION_BAR_MENU).click();
        return new UserPage(driver);
    }

    /**
     * @return Имя юзера
     */
    public String getUserName() {
        return driver.findElement(USER_NAME).getText();
    }
}
