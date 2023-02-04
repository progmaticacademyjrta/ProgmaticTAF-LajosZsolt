package hu.progmatic.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class LoginPage {
    WebDriver driver;
    WebDriverWait wait;
    By menuToggleButtonBy = By.id("menu-toggle");
    By loginInMenuBy = By.xpath("//*[@id='sidebar-wrapper']/ul/li[3]/a");
    By userNameInputBy = By.id("txt-username");
    By userPasswordInputBy = By.id("txt-password");
    By loginButtonBy = By.id("btn-login");
    By loginFailedMessageBy = By.xpath("//*[@id='login']/div/div/div[1]/p[2]");
    //*[@id="login"]/div/div/div[1]/p[2]


    public LoginPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }


    public void goToLoginPage() throws InterruptedException {
        driver.get("https://katalon-demo-cura.herokuapp.com");
        WebElement menuToggleButton = driver.findElement(menuToggleButtonBy);
        menuToggleButton.click();
        Thread.sleep(2000);
        WebElement loginInMenu = driver.findElement(loginInMenuBy);
        loginInMenu.click();
        Thread.sleep(3000);
        Assert.assertEquals(driver.getCurrentUrl(),
                "https://katalon-demo-cura.herokuapp.com/profile.php#login");
        System.out.println("Open the Login page was OK");
    }
    public void loginWithWrongData(){
        WebElement userNameInput = driver.findElement(userNameInputBy);
        userNameInput.sendKeys("Wronguser");

        WebElement userPasswordInput = driver.findElement(userPasswordInputBy);
        userPasswordInput.sendKeys("Wrongpassword");

        WebElement loginButton = driver.findElement(loginButtonBy);
        loginButton.click();

        WebElement loginFailedMessage = driver.findElement(loginFailedMessageBy);
        //System.out.println(loginFailedMessage.getText());
        Assert.assertEquals("Login failed! Please ensure the username and password are valid.", loginFailedMessage.getText());
        System.out.println("With wrong login name and pasword, the login not possible, there is a faild message.");
        System.out.println("Login failed! Please ensure the username and password are valid.");
    }


}
