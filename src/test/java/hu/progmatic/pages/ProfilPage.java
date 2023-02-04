package hu.progmatic.pages;

import com.beust.ah.A;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class ProfilPage {
    WebDriver driver;
    WebDriverWait wait;
    By menuToggleButtonBy = By.id("menu-toggle");
    //By loginInMenuBy = By.xpath("//*[@id='sidebar-wrapper']/ul/li[3]/a");
    By loginInMenuBy = By.linkText("Login");
    By userNameInputBy = By.id("txt-username");
    By userPasswordInputBy = By.id("txt-password");
    By loginButtonBy = By.id("btn-login");
    By menuToggleButton2By = By.id("menu-toggle");
    //By profileInMenuBy = By.xpath("//*[@id='sidebar-wrapper']/ul/li[4]/a");
    By profileInMenuBy = By.linkText("Profile");
    By profilePageHeadBy = By.xpath("//*[@id='profile']/div/div/div");

    public ProfilPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public void loadProfilPage() throws InterruptedException {
        driver.get("https://katalon-demo-cura.herokuapp.com");

        WebElement menuToggleButton = driver.findElement(menuToggleButtonBy);
        menuToggleButton.click();
        Thread.sleep(2000);
        WebElement loginInMenu = driver.findElement(loginInMenuBy);
        loginInMenu.click();

        WebElement userNameInput = driver.findElement(userNameInputBy);
        userNameInput.sendKeys("John Doe");
        WebElement userPasswordInput = driver.findElement(userPasswordInputBy);
        userPasswordInput.sendKeys("ThisIsNotAPassword");

        WebElement loginButton = driver.findElement(loginButtonBy);
        loginButton.click();

        WebElement menuToggleButton2 = driver.findElement(menuToggleButton2By);
        menuToggleButton2.click();
        Thread.sleep(1000);
        WebElement profileInMenu = driver.findElement(profileInMenuBy);
        profileInMenu.click();

        WebElement profilePageHeadText = driver.findElement(profilePageHeadBy);
        System.out.println(profilePageHeadText.getText());
        Assert.assertEquals("Profile\n" +
                "Under construction.\n" +
                "Logout", profilePageHeadText.getText());

        //Assert.assertEquals(driver.getCurrentUrl(), "https://katalon-demo-cura.herokuapp.com/profile.php#profile");
        System.out.println("The Profile page is loaded.");
    }
}
