package core.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Страница подскастов
 * https://vk.com/feed?section=podcasts
 */
public class PodcastPage extends BasePage {
    private static final By PODCASTS_NEWS = By.id("ui_rmenu_podcasts");
    private static final By STAR_FOR_ADD = By.className("podcast_snippet__fave");
    private static final By NAME_PODCAST = By.className("podcast_snippet__title");

    public PodcastPage(WebDriver driver) {
        super(driver);
    }

    /**
     * Переход на страницу подскастов
     *
     * @return PodcastPage()
     */
    public PodcastPage openPodcasts() {
        driver.findElement(PODCASTS_NEWS).click();
        return new PodcastPage(driver);
    }

    /**
     * Добавление подскаста в закладки
     */
    public void addPodcastsInBookmarks() {
        driver.findElement(STAR_FOR_ADD).click();
    }

    /**
     * Получает имя подскаста
     *
     * @return имя подскаста
     */
    public String getPodcastName() {
        return driver.findElement(NAME_PODCAST).getText();
    }
}
