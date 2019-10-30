package core.pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BasePage {
    protected final WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    protected void checkMainElementIsLoaded(By element) {
        Assert.assertTrue("Главный элемент не загрузился", driver.findElement(element).isDisplayed());
    }

    protected boolean isVisible(By element) {
        try {
            return (driver.findElement(element).isDisplayed());
        } catch (Exception e) {
            return false;
        }
    }

    protected void pause(int milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            throw new IllegalStateException("Ошибка при паузе", e);
        }
    }

    protected void waitUntilVisible(By element) {
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.visibilityOfElementLocated(element));
    }
}
