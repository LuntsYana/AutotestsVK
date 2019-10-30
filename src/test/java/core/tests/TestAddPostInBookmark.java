package core.tests;

import core.pages.BookmarksPage;
import core.pages.HomePage;
import core.pages.LeftMenuPage;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Date;

public class TestAddPostInBookmark extends TestBase {

    private BookmarksPage bookmarksPage;
    private Date date = new Date();
    private String postText = date.toString();

    @Before
    public void setUp() {
        super.setUp();
        bookmarksPage = new LeftMenuPage(driver).openBookmarks();
    }


    /**
     * Создаем пост
     * Добавляем пост в закладки
     * Переходим в закладки и проверяем, что пост добавлен
     */
    @Test
    public void checkAddingPost() {
        new HomePage(driver)
                .openAllPosts()
                .createPost(postText);
        driver.navigate().refresh();
        String postId = new HomePage(driver).addPostInBookmarks(postText);
        Assert.assertEquals("Пост не добавлен", postId, bookmarksPage.getAttributeDataPostId());
    }
}


