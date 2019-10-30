package core.tests;

import core.pages.HomePage;
import core.pages.LeftMenuPage;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestCheckDisplayBookmarksInMenu extends TestBase {

    /**
     * 1) Логинимся
     * 2) Проверяем присутсвие закладок в левой колонке
     * 2.1) Если есть, убирает закладки в настройках
     */
    @Before
    public void setUp() {
        super.setUp();
        new LeftMenuPage(driver).checkBookmarksInLeftMenu();
    }

    /**
     * Проверяем возможность добавление закладок через настройки
     * После добавления проверяем, что закладки присутствуют в левой колонке
     */
    @Test
    public void addBookmarksInMenu() {
        boolean bookmarks = new HomePage(driver)
                .goToSetting()
                .goToMenuSetting()
                .clickOnBookmarks()
                .isVisibleBookmarksInLeftMenu();
        Assert.assertTrue("Закладки не присутствуют в левой колонке", bookmarks);
    }
}