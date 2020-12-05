package ru.stqa.pft.adressbook.tests;


import org.testng.annotations.*;
import ru.stqa.pft.adressbook.model.ContactData;
import ru.stqa.pft.adressbook.model.GroupData;

import static org.testng.Assert.*;

public class ContactDeletionTest extends TestBase {

    @Test

    public void testContactDeletion() throws Exception {
        app.getNavigationHelper().goToHomePage();
        if (! app.getContactHelper().isTHereAContact()) {
            app.getContactHelper().createContact(new ContactData("firstName",
                    "middleName",
                    "lastName",
                    "nickName",
                    "testTitle",
                    "testCompany",
                    "test address",
                    "1",
                    "+23456789",
                    "+12345677",
                    "n/a",
                    "test@test.com",
                    "n/a",
                    "18",
                    "December",
                    "1990",
                    "test1",
                    "secondaryHome",
                    "secondary address"
            ),true);
        }
        app.getContactHelper().selectContact();
        app.getContactHelper().clickDeleteContact();
        app.acceptNextAlert = true;
        assertTrue(app.closeAlertAndGetItsText().matches("^Delete 1 addresses[\\s\\S]$"));
        app.getNavigationHelper().goToHomePage();
    }

}
