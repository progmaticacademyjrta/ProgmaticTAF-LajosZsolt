package hu.progmatic.testcases;

import hu.progmatic.driverfactory.DriverBaseTest;
import hu.progmatic.pages.AppointmentPage;
import org.testng.annotations.Test;

public class AppointmentPageTests extends DriverBaseTest {
    AppointmentPage appointmentPage;

    @Test(description = "TC04: Make a complet appointment, finished with a confirmation.", groups = "smoke")
    public void makeAppointmentTest() throws InterruptedException {
        appointmentPage = new AppointmentPage(driver, wait);

        appointmentPage.makeAppointmentLogin();
        appointmentPage.makeAppointment();
    }


}
