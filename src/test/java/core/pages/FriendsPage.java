package core.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Страница "Друзья"
 * https://vk.com/friends
 */
public class FriendsPage extends BasePage {
    private static final By FRIEND = By.xpath("//*[@class='friends_list_bl']/div[1]");
    private static final By PHOTO_FRIEND = By.className("friends_photo_wrap");

    public FriendsPage(WebDriver driver) {
        super(driver);
    }

    /**
     * Переход на сраницу юзера
     */
    public UserPage goToPageUser() {
        driver.findElement(FRIEND).findElement(PHOTO_FRIEND).click();
        return new UserPage(driver);
    }
}
