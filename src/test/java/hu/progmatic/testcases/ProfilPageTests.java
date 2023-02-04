package hu.progmatic.testcases;

import hu.progmatic.driverfactory.DriverBaseTest;
import hu.progmatic.pages.AppointmentPage;
import hu.progmatic.pages.HomePage;
import hu.progmatic.pages.LoginPage;
import hu.progmatic.pages.ProfilPage;
import org.testng.annotations.Test;

public class ProfilPageTests extends DriverBaseTest {
    ProfilPage profilPage;

    @Test(description = "TC05: Profil page loading test", groups = "regression")
    public void homepageLoadedTest() throws InterruptedException {
       profilPage = new ProfilPage(driver, wait);


       profilPage.loadProfilPage();


    }

}
