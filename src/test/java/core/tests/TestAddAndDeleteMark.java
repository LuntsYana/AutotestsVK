package core.tests;

import core.pages.BookmarksPage;
import core.pages.LeftMenuPage;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class TestAddAndDeleteMark extends TestBase {

    private static final String NAME_MARK = RandomStringUtils.randomAlphabetic(10);
    private BookmarksPage bookmarksPage;

    @Before
    public void setUp() {
        super.setUp();
        bookmarksPage = new LeftMenuPage(driver).openBookmarks();
    }

    /**
     * Проверяем, что можно создать новую метку
     */
    @Test
    public void testAddMark() {
        bookmarksPage.createMark(NAME_MARK);
        Assert.assertTrue("Проверяем, что созданная метка отображается", bookmarksPage.isVisibleCreatedMark(NAME_MARK));
    }

    /**
     * Проверяем, что можно удалить метку
     */
    @Test
    public void testDeleteMark() {
        bookmarksPage.deleteMark(NAME_MARK);
        Assert.assertFalse("Проверяем, что метка удалилась", bookmarksPage.isVisibleCreatedMark(NAME_MARK));
    }
}