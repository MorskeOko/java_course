package ru.stqa.pft.adressbook.tests;


import org.testng.annotations.*;
import static org.testng.Assert.*;

public class ContactDeletionTest extends TestBase {

    @Test
    //поменяла местами методы 3 и 4
    public void testContactDeletion() throws Exception {
        app.getNavigationHelper().goToHomePage();
        app.getContactHelper().selectContact();
        app.getContactHelper().clickDeleteContact();
        app.acceptNextAlert = true;
        assertTrue(app.closeAlertAndGetItsText().matches("^Delete 1 addresses[\\s\\S]$"));
        app.getNavigationHelper().goToHomePage();
    }

}
