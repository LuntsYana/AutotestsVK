package core.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static core.Constants.DELETE_FROM_BOOKMARKS;

/**
 * Страница "Сообщества"
 * https://vk.com/groups
 */
public class GroupPage extends BasePage {
    private static final By MENU_GROUP_MORE = By.id("page_menu_group_more");
    private static final By ADD_IN_BOOKMARKS = By.className("page_menu_group_bookmark");

    public GroupPage(WebDriver driver) {
        super(driver);
    }

    /**
     * Добавляет группу в закладки
     *
     * @return GroupPage()
     */
    public GroupPage addGroupInBookmarks() {
        driver.findElement(MENU_GROUP_MORE).click();
        driver.findElement(ADD_IN_BOOKMARKS).click();
        return new GroupPage(driver);
    }

    /**
     * Проверяет, если группа добавлена в закладки, удаляет из закладок
     *
     * @return GroupPage()
     */
    public GroupPage deleteGroupFromBookmarks() {
        driver.findElement(MENU_GROUP_MORE).click();
        WebElement addButton = driver.findElement(ADD_IN_BOOKMARKS);
        if (addButton.getText().contentEquals(DELETE_FROM_BOOKMARKS)) {
            addButton.click();
        }
        return new GroupPage(driver);
    }
}
