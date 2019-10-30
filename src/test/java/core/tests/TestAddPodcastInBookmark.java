package core.tests;

import core.pages.BookmarksPage;
import core.pages.LeftMenuPage;
import core.pages.PodcastPage;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestAddPodcastInBookmark extends TestBase {
    private PodcastPage podcastPage;

    @Before
    public void setUp() {
        super.setUp();
        new LeftMenuPage(driver).openNews();
        podcastPage = new PodcastPage(driver).openPodcasts();
    }

    @Test
    public void addPodcastInBookmark() {
        podcastPage.addPodcastsInBookmarks();
        String podcastName = podcastPage.getPodcastName();
        BookmarksPage bookmarksPage = new LeftMenuPage(driver).openBookmarks().goToPodcastsBlock();
        Assert.assertEquals("Проверяем, что подскаст добавлен в закладки", podcastName,
                bookmarksPage.getNamePodcastInBookmarks());
    }
}
