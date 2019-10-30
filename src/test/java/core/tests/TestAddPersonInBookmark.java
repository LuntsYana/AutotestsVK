package core.tests;

import core.pages.BookmarksPage;
import core.pages.LeftMenuPage;
import core.pages.UserPage;
import org.junit.Assert;
import org.junit.Test;

/**
 * Удаляем юзера из закладок
 */
public class TestAddPersonInBookmark extends TestBase {
    public void setUp() {
        super.setUp();
        new LeftMenuPage(driver)
                .openFriends()
                .goToPageUser()
                .deleteUserFromBookmarks();
        driver.navigate().refresh();
    }

    /**
     * Проверка, что пользователя можно добавить в закладки
     */
    @Test
    public void addUserBookmarks() {
        new LeftMenuPage(driver)
                .openFriends()
                .goToPageUser()
                .addInBookmarks();
        String userName = new UserPage(driver).getUserName();
        BookmarksPage bookmarksPage = new LeftMenuPage(driver)
                .openBookmarks()
                .goToUsersBlock();
        Assert.assertEquals("Пользователь не добавлен в закладки", userName,
                bookmarksPage.getUserNameInBookmarks());

    }
}
