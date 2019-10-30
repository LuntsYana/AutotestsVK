package core.tests;

import core.pages.BookmarksPage;
import core.pages.LeftMenuPage;
import core.pages.SearchPage;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static core.Constants.GROUP_NAME;

public class TestAddGroupInBookmark extends TestBase {

    /**
     * Удаляем группу из закладок до автотеста
     */
    @Before
    public void setUp() {
        super.setUp();
        new SearchPage(driver)
                .searchGroup(GROUP_NAME)
                .chooseGroup(GROUP_NAME)
                .deleteGroupFromBookmarks();
        driver.navigate().refresh();
    }

    /**
     * Добавляем группы в закладки, проверяем, что группа отображается в закладках
     */
    @Test
    public void addGroupInBookmark() {
        new SearchPage(driver)
                .searchGroup(GROUP_NAME)
                .chooseGroup(GROUP_NAME)
                .addGroupInBookmarks();
        BookmarksPage bookmarksPage = new LeftMenuPage(driver)
                .openBookmarks()
                .goToGroupsBlock();
        Assert.assertEquals("Проверяем, что группа добавлена в закладки", GROUP_NAME,
                bookmarksPage.getGroupNameInBookmarks());
    }
}
