package ru.stqa.pft.adressbook.tests;


import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.adressbook.model.ContactData;

import java.util.List;

import static org.testng.Assert.assertTrue;

public class ContactDeletionTest extends TestBase {

    @Test

    public void testContactDeletion() throws Exception {
        int index = 0;
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
        List<ContactData> before = app.getContactHelper().getContactList();
        app.getContactHelper().selectContact(index);
        app.getContactHelper().clickDeleteContact();
        app.acceptNextAlert = true;
        assertTrue(app.closeAlertAndGetItsText().matches("^Delete 1 addresses[\\s\\S]$"));
        app.getNavigationHelper().goToHomePage();
        List<ContactData> after = app.getContactHelper().getContactList();
        Assert.assertEquals(after.size(), before.size()-1);
        before.remove(index);
        Assert.assertEquals(before, after);
    }

}
