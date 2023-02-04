package hu.progmatic.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class AppointmentPage {
    WebDriver driver;
    WebDriverWait wait;
    By userNameInputBy = By.id("txt-username");
    By userPasswordInputBy = By.id("txt-password");
    By loginButtonBy = By.id("btn-login");
    By makeAppointmentButtonBy = By.id("btn-make-appointment");
    By facilityCenterInputBy = By.id("combo_facility");
    By applyForHospitalReadmissionCheckboxBy = By.id("chk_hospotal_readmission");
    By healthcareProgramRadioButtonBy = By.id("radio_program_none");
    By visitDateInputBy = By.id("txt_visit_date");
    By commentTextInputBy = By.id("txt_comment");
    By bookAppointmentButtonBy = By.id("btn-book-appointment");
    By appointmentConfirmationMessageBy = By.xpath("//*[@id='summary']/div/div/div[1]");
    By menuToggleButtonBy = By.id("menu-toggle");
    By logutFromMenuBy = By.linkText("Logout");

    public AppointmentPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public void makeAppointmentLogin() throws InterruptedException {
        driver.get("https://katalon-demo-cura.herokuapp.com");
        WebElement makeAppointmentButton = driver.findElement(makeAppointmentButtonBy);
        makeAppointmentButton.click();
        Thread.sleep(3000);

        WebElement userNameInput = driver.findElement(userNameInputBy);
        userNameInput.sendKeys("John Doe");

        WebElement userPasswordInput = driver.findElement(userPasswordInputBy);
        userPasswordInput.sendKeys("ThisIsNotAPassword");

        WebElement loginButton = driver.findElement(loginButtonBy);
        loginButton.click();
        Assert.assertEquals(driver.getCurrentUrl(),
                "https://katalon-demo-cura.herokuapp.com/#appointment");

        System.out.println("Login to Appointment finished.");
    }

    public void makeAppointment() {
        Select facilityCenterInput = new Select(driver.findElement(facilityCenterInputBy));
        facilityCenterInput.selectByVisibleText("Seoul CURA Healthcare Center");

        WebElement applyForHospitalReadmission = driver.findElement(applyForHospitalReadmissionCheckboxBy);
        applyForHospitalReadmission.click();

        WebElement healthcareProgramChoose = driver.findElement(healthcareProgramRadioButtonBy);
        healthcareProgramChoose.sendKeys("None");

        WebElement visitDateInput = driver.findElement(visitDateInputBy);
        visitDateInput.sendKeys("04-02-2023");

        WebElement commentTextBox = driver.findElement(commentTextInputBy);
        commentTextBox.sendKeys("This is an automation test!");

        WebElement bookAppointmentButton = driver.findElement(bookAppointmentButtonBy);
        bookAppointmentButton.click();

        WebElement appointmentConfirmationMessage = driver.findElement(appointmentConfirmationMessageBy);
        System.out.println(appointmentConfirmationMessage.getText());
        Assert.assertEquals("Appointment Confirmation\n" +
                "Please be informed that your appointment has been booked as following:", appointmentConfirmationMessage.getText());
        System.out.println("The appointement has been booked at 04.02.2023.");
    }

    public void signOutFromAppointment() throws InterruptedException {
        WebElement menuToggleButton = driver.findElement(menuToggleButtonBy);
        menuToggleButton.click();
        Thread.sleep(2000);
        WebElement logOutFromAppointment = driver.findElement(logutFromMenuBy);
        logOutFromAppointment.click();
        Assert.assertEquals(driver.getCurrentUrl(), "https://katalon-demo-cura.herokuapp.com/");
        System.out.println("Finished an appointment, and logout.");
    }


}
