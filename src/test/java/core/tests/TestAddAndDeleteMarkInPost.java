package core.tests;

import core.pages.BookmarksPage;
import core.pages.LeftMenuPage;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestAddAndDeleteMarkInPost extends TestBase {
    private BookmarksPage bookmarksPage;

    @Before
    public void setUp() {
        super.setUp();
        bookmarksPage = new LeftMenuPage(driver).openBookmarks();
    }

    /**
     * Добавлем метку к посту
     * Проверяем, что метка добавилась
     */
    @Test
    public void testAddPostMarkReadLater() {
        bookmarksPage.addMarkReadLaterInPost();
        Assert.assertEquals("Метка не добавлена", "Прочитать позже", bookmarksPage.getTagText());
    }

    /**
     * Удаляем метку из того же поста
     * Проверяем, что метка удалилась
     */
    @Test
    public void testDeletePostMarkReadLater() {
        bookmarksPage.deleteMarkReadLaterInPost();
        Assert.assertFalse("Метка не удалилась", bookmarksPage.isVisibleMarkInPost());
    }
}
