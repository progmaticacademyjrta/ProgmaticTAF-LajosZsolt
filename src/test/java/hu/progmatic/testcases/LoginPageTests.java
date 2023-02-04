package hu.progmatic.testcases;

import hu.progmatic.driverfactory.DriverBaseTest;
import hu.progmatic.pages.HomePage;
import hu.progmatic.pages.LoginPage;
import org.testng.annotations.Test;

public class LoginPageTests extends DriverBaseTest {
    HomePage homePage;
    LoginPage loginPage;

    @Test(description = "TC03: Login page test with not correct data, the message is: Login failed! " +
            "Please ensure the username and password are valid.", groups = "regression")
    public void loginTestWithWrongData() throws InterruptedException {
       // homePage = new HomePage(driver, wait);
        loginPage = new LoginPage(driver, wait);
        loginPage.goToLoginPage();
        loginPage.loginWithWrongData();
    }


}
