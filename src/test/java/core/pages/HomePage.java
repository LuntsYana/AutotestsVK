package core.pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import static core.Constants.*;

/**
 * Главная страница и работа с постами
 * https://vk.com/feed
 */
public class HomePage extends BasePage {
    private static final By PROFILE_LINK = By.id("top_profile_link");
    private static final By SETTINGS = By.id("top_settings_link");
    private static final By ACTION_MENU = By.className("ui_actions_menu_icons");
    private static final By INPUT_POST = By.id("post_field");
    private static final By SEND_POST_BUTTON = By.id("send_post");
    private static final By POST = By.xpath("//div[@id='page_wall_posts']/div[1]");
    private static final By TEXT_POST = By.xpath("//div[contains(@class, 'wall_post_text')]");
    private static final By SAVE_IN_BOOKMARKS_BUTTON = By.xpath("//a[contains(text(), '" + SAVE_IN_BOOKMARK + "')]");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    /**
     * Открываем все посты
     */
    public HomePage openAllPosts() {
        driver.get(POSTS_PAGE);
        return new HomePage(driver);
    }

    /**
     * @return SettingPage()
     */
    public SettingPage goToSetting() {
        waitUntilVisible(PROFILE_LINK);
        driver.findElement(PROFILE_LINK).click();
        driver.findElement(SETTINGS).click();
        return new SettingPage(driver);
    }

    /**
     * Добавляем пост в закладки
     *
     * @param postText текст поста
     * @return postId
     */
    public String addPostInBookmarks(String postText) {
        String postId = driver.findElement(POST).getAttribute("data-post-id");
        Assert.assertEquals("Текст отличается от " + postText, postText,
                driver.findElement(POST).findElement(TEXT_POST).getText());
        WebElement actionMenu = driver.findElement(POST).findElement(ACTION_MENU);
        Actions showMenu = new Actions(driver);
        showMenu.moveToElement(actionMenu).build().perform();
        WebElement bookmarksButton = actionMenu.findElement(SAVE_IN_BOOKMARKS_BUTTON);
        bookmarksButton.click();
        Assert.assertEquals("Текст на кнопке отличается", DELETE_FROM_BOOKMARKS, bookmarksButton.getText());
        return postId;
    }

    /**
     * Создаем пост
     *
     * @param postText текст поста
     */
    public void createPost(String postText) {
        driver.findElement(INPUT_POST).sendKeys(postText);
        driver.findElement(SEND_POST_BUTTON).click();
    }
}
