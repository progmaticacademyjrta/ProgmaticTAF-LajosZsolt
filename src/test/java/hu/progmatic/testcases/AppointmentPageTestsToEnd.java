package hu.progmatic.testcases;

import hu.progmatic.driverfactory.DriverBaseTest;
import hu.progmatic.pages.AppointmentPage;
import org.testng.annotations.Test;

public class AppointmentPageTestsToEnd extends DriverBaseTest {
    AppointmentPage appointmentPage;

    @Test(description = "TC06: Make a complet appointment, finished with a confirmation, and go to the HomePage", groups = "smoke")
    public void makeAppointmentTest() throws InterruptedException {
        appointmentPage = new AppointmentPage(driver, wait);

        appointmentPage.makeAppointmentLogin();
        appointmentPage.makeAppointment();
        appointmentPage.signOutFromAppointment();
    }


}
