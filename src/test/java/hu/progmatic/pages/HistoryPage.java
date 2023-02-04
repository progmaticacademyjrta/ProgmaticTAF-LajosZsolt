package hu.progmatic.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class HistoryPage {
    WebDriver driver;
    WebDriverWait wait;
    By menuToggleButtonBy = By.id("menu-toggle");
    By historyInMenuBy = By.linkText("History");

    public HistoryPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public void goHistoryPage() throws InterruptedException {
        driver.get("https://katalon-demo-cura.herokuapp.com");
        WebElement menuToggleButton = driver.findElement(menuToggleButtonBy);
        menuToggleButton.click();
        Thread.sleep(2000);
        WebElement historyInMenu = driver.findElement(historyInMenuBy);
        historyInMenu.click();
        Thread.sleep(3000);
        Assert.assertEquals(driver.getCurrentUrl(),
                "https://katalon-demo-cura.herokuapp.com/history.php#history");
        System.out.println("Open the History page was OK");




    }
}
