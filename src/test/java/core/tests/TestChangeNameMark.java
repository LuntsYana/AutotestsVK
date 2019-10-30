package core.tests;

import core.pages.BookmarksPage;
import core.pages.LeftMenuPage;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestChangeNameMark extends TestBase {
    private BookmarksPage bookmarksPage;
    private String markName = RandomStringUtils.randomAlphabetic(10);
    private String newMarkName = RandomStringUtils.randomAlphabetic(10);

    @Before
    public void setUp() {
        super.setUp();
        bookmarksPage = new LeftMenuPage(driver).openBookmarks();
    }

    @Test
    public void changeNameMark() {
        String bookmarksPage = new BookmarksPage(driver)
                .createMark(markName)
                .changeMark(markName, newMarkName);
        Assert.assertNotEquals("Проверяем, что сообщение изменилось", bookmarksPage);
    }
}
