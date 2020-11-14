package ru.stqa.pft.adressbook.tests;


import org.testng.annotations.*;

import static org.testng.Assert.*;

public class ContactDeletionTest extends TestBase {

    @Test
    public void testContactDeletion() throws Exception {
        app.getNavigationHelper().goToHomePage();
        app.getContactHelper().selectContact();
        app.acceptNextAlert = true;
        app.getContactHelper().clickDeleteContact();
        assertTrue(app.closeAlertAndGetItsText().matches("^Delete 1 addresses[\\s\\S]$"));
    }

}
