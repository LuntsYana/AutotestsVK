package core.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchPage extends BasePage {
    private static final By INPUT_SEARCH = By.id("ts_input");
    private static final By GROUP_NAME = By.className("ts_clist_hl");
    private static final By PROFILE_NAME = By.className("top_profile_name");

    public SearchPage(WebDriver driver) {
        super(driver);
    }

    /**
     * Поиск группы
     *
     * @return SearchPage()
     */
    public SearchPage searchGroup(String search) {
        waitUntilVisible(PROFILE_NAME);
        driver.findElement(INPUT_SEARCH).sendKeys(search);
        return new SearchPage(driver);
    }

    /**
     * Выбираем группу
     *
     * @return GroupPage()
     */
    public GroupPage chooseGroup(String search) {
        if (driver.findElement(GROUP_NAME).getText().contentEquals(search)) {
            driver.findElement(GROUP_NAME).click();
        }
        return new GroupPage(driver);
    }
}
