package core.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Меню настроек левого меню
 * https://vk.com/settings -> зайти в меню настроек отображения левого меню
 */
public class MenuSettingPage extends BasePage {
    private static final By BOOKMARKS = By.xpath(".//*[@id='settings_menu_0']/a[12]");
    private static final By MAIN_PAGE = By.className("popup_box_container");
    private static final By SAVE = By.xpath("//button[contains(@class, 'flat_button') and text()='Сохранить']");

    public MenuSettingPage(WebDriver driver) {
        super(driver);
        checkMainElementIsLoaded(MAIN_PAGE);
    }

    /**
     * Кликает на закладки в меню отображения элементов
     *
     * @return LeftMenuPage()
     */
    public LeftMenuPage clickOnBookmarks() {
        driver.findElement(BOOKMARKS).click();
        driver.findElement(SAVE).click();
        return new LeftMenuPage(driver);
    }
}
