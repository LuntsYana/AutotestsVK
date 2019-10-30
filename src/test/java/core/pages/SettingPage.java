package core.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Страница настроек
 * https://vk.com/settings
 */
public class SettingPage extends BasePage {
    private static final By MAIN_PAGE = By.className("page_block");
    private static final By SETTING_MENU = By.className("settings_tabindex_link");

    public SettingPage(WebDriver driver) {
        super(driver);
        checkMainElementIsLoaded(MAIN_PAGE);
    }

    /**
     * @return MenuSettingPage()
     */
    public MenuSettingPage goToMenuSetting() {
        waitUntilVisible(SETTING_MENU);
        driver.findElement(SETTING_MENU).click();
        return new MenuSettingPage(driver);
    }
}
