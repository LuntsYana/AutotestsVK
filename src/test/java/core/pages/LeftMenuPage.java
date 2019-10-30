package core.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static core.Constants.SITE_HOME_PAGE;

/**
 * Левое меню
 */
public class LeftMenuPage extends BasePage {
    private static final By BOOKMARKS = By.id("l_fav");
    private static final By MAIN_COLUMN = By.id("side_bar_inner");
    private static final By FRIENDS = By.id("l_fr");
    private static final By NEWS = By.id("l_nwsf");
    private static final By ALL_BOOKMARKS = By.id("ui_rmenu_all");

    public LeftMenuPage(WebDriver driver) {
        super(driver);
        waitUntilVisible(MAIN_COLUMN);
        checkMainElementIsLoaded(MAIN_COLUMN);

    }

    /**
     * Проверка отображения "Закладок" в левом меню
     *
     * @return boolean
     */
    public boolean isVisibleBookmarksInLeftmenu() {
        waitUntilVisible(BOOKMARKS);
        return true;
    }


    /**
     * Кликает на Закладки
     *
     * @return BookmarksPage()
     */
    public BookmarksPage openBookmarks() {
        driver.findElement(BOOKMARKS).click();
        waitUntilVisible(ALL_BOOKMARKS);
        driver.findElement(ALL_BOOKMARKS).click();
        return new BookmarksPage(driver);
    }

    /**
     * Кликает на Друзья
     *
     * @return FriendsPage()
     */
    public FriendsPage openFriends() {
        driver.findElement(FRIENDS).click();
        return new FriendsPage(driver);
    }

    public void openNews() {
        waitUntilVisible(NEWS);
        driver.findElement(NEWS).click();
    }

    public void checkBookmarksInLeftMenu() {
        try {
            if (isVisibleBookmarksInLeftmenu()) {
                new HomePage(driver).goToSetting().goToMenuSetting().clickOnBookmarks();
                driver.get(SITE_HOME_PAGE);
            }
        }
        //Падает если bookmarksIsDisplayed() = false, игнорируем эту ошибку и выполняем тест
        catch (Exception ignored) {
        }
    }
}