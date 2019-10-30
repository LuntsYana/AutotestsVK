package core.pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import static core.Constants.BOOKMARKS_PAGE;

/**
 * Страница "Закладки"
 * https://vk.com/bookmarks
 */
public class BookmarksPage extends BasePage {

    private static final By POST = By.xpath("//div[contains(@class, 'bookmarks_rows')]//div[contains(@class, 'bookmarks_row')]" +
            "/div[contains(@class, 'post')][1]");
    private static final By CREATE_MARK_BUTTON = By.xpath("//*[@id='ui_rmenu_tags_dropdown_list']/div/button");
    private static final By INPUT_FOR_MARK = By.id("bookmark_tag_name");
    private static final By SAVE_NEW_MARK_BUTTON = By.id("save_tag_btn");
    private static final By DELETE_MARK_BUTTON = By.className("bookmarks_tag_delete_btn");
    private static final By CONFURM_DELETE_BUTTON = By.xpath("//button[contains(@class, 'flat_button') and text()='Да']");
    private static final By UI_MENU = By.xpath("//div[contains(@class, 'bookmarks_rows')]//div[@class='ui_actions_menu_icons']");
    private static final By SETTING_MARK = By.className("ui_actions_menu_item_sublist");
    private static final By READ_LATER = By.xpath(".//*[@data-tag-name = 'Прочитать позже']");
    private static final By BOOKMARK_TAG = By.className("bookmark_tags");
    private static final By EDIT_MARK_BUTTON = By.className("bookmarks_tag_edit_btn");
    private static final By USERS_BLOCK = By.id("ui_rmenu_user");
    private static final By USER_NAME = By.className("bookmark_page_item__name");
    private static final By BOOKMARK_FOOTER = By.className("bookmark_footer");
    private static final By GROUPS_BLOCK = By.id("ui_rmenu_group");
    private static final By GROUP_NAME = By.className("group_link");
    private static final By PODCASTS_BLOCK = By.id("ui_rmenu_podcast");
    private static final By NAME_PODCAST = By.className("podcast_snippet__title");


    public BookmarksPage(WebDriver driver) {
        super(driver);
    }

    /**
     * Получает атрибут data-post-id
     *
     * @return атрибут data-post-id
     */
    public String getAttributeDataPostId() {
        driver.get(BOOKMARKS_PAGE);
        return driver.findElement(POST).getAttribute("data-post-id");
    }

    /**
     * Создаем метку и проверяем, что она появилась и текст именно тот, что написали в инпуте
     *
     * @return BookmarksPage()
     */
    public BookmarksPage createMark(String markName) {
        driver.findElement(CREATE_MARK_BUTTON).click();
        driver.findElement(INPUT_FOR_MARK).sendKeys(markName);
        driver.findElement(SAVE_NEW_MARK_BUTTON).click();
        String nameMarkText = driver.findElement(By.linkText(markName)).getText();
        Assert.assertEquals("Текст тэга неверный", markName, nameMarkText);
        return new BookmarksPage(driver);
    }

    public boolean isVisibleCreatedMark(String markName) {
        return isVisible(By.linkText(markName));
    }

    /**
     * Удаляем метку
     *
     * @return BookmarksPage()
     */
    public BookmarksPage deleteMark(String markName) {
        WebElement mark = driver.findElement(By.linkText(markName));
        Actions actions = new Actions(driver);
        actions.moveToElement(mark).build().perform();
        mark.findElement(DELETE_MARK_BUTTON).click();
        WebElement deleteButton = driver.findElement(CONFURM_DELETE_BUTTON);
        deleteButton.click();
        return new BookmarksPage(driver);
    }

    /**
     * Добавляем в пост метку
     */
    public void addMarkReadLaterInPost() {
        Actions builder = new Actions(driver);
        pause(1000);
        builder.moveToElement(driver.findElement(UI_MENU))
                .click(driver.findElement(SETTING_MARK))
                .click(driver.findElement(READ_LATER));
        Action mouseoverAndClick = builder.build();
        mouseoverAndClick.perform();
    }


    /**
     * @return Текст тэга
     */
    public String getTagText() {
        return driver.findElement(BOOKMARK_TAG).getText();
    }

    public boolean isVisibleMarkInPost() {
        return isVisible(BOOKMARK_FOOTER);
    }

    /**
     * Меняем имя метки и сохраняем, проверяем, что оно изменилось
     *
     * @param newMarkName новое имя метки
     */
    public String changeMark(String nameMark, String newMarkName) {
        WebElement mark = driver.findElement(By.linkText(nameMark));
        String markText = mark.getText();
        Actions actions = new Actions(driver);
        actions.moveToElement(mark).build().perform();
        confirmChangeMark(nameMark, newMarkName);
        return markText;

    }

    private void confirmChangeMark(String nameMark, String newMarkName) {
        driver.findElement(By.linkText(nameMark)).findElement(EDIT_MARK_BUTTON).click();
        WebElement input = driver.findElement(INPUT_FOR_MARK);
        input.clear();
        input.sendKeys(newMarkName);
        driver.findElement(SAVE_NEW_MARK_BUTTON).click();
    }

    /**
     * Переход в блок "Люди"
     * <p>
     * TODO сделать пэйдж "Люди", когда расширятся автотесты. Пока это не целесобразно, есть один метод только
     *
     * @return BookmarksPage()
     */
    public BookmarksPage goToUsersBlock() {
        driver.findElement(USERS_BLOCK).click();
        pause(100); /* waitUntil не помогает, нужна именно пауза,
        иначе автотест проходит только на второй перезапуск */
        return new BookmarksPage(driver);
    }

    /**
     * Переход в блок "Группы"
     * <p>
     * TODO сделать пэйдж "Сообщества", когда расширятся автотесты. Пока это не целесобразно, есть один метод только
     *
     * @return BookmarksPage()
     */
    public BookmarksPage goToGroupsBlock() {
        driver.findElement(GROUPS_BLOCK).click();
        pause(100); /* waitUntil не помогает, нужна именно пауза,
        иначе автотест проходит только на второй перезапуск */
        return new BookmarksPage(driver);
    }

    /**
     * @return имя юзера
     */
    public String getUserNameInBookmarks() {
        return driver.findElement(USER_NAME).getText();
    }

    /**
     * @return имя группы
     */
    public String getGroupNameInBookmarks() {
        waitUntilVisible(GROUP_NAME);
        return driver.findElement(GROUP_NAME).getText();
    }

    public BookmarksPage goToPodcastsBlock() {
        driver.findElement(PODCASTS_BLOCK).click();
        return new BookmarksPage(driver);
    }

    /**
     * @return имя подскаста
     */
    public String getNamePodcastInBookmarks() {
        return driver.findElement(NAME_PODCAST).getText();
    }

    /**
     * Удаляем метку
     */
    public void deleteMarkReadLaterInPost() {
        Actions builder = new Actions(driver);
        pause(1000);
        builder.moveToElement(driver.findElement(UI_MENU))
                .click(driver.findElement(SETTING_MARK))
                .click(driver.findElement(READ_LATER));
        Action mouseoverAndClick = builder.build();
        mouseoverAndClick.perform();
    }

}
