package ru.stqa.pft.adressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.adressbook.model.ContactData;

import java.util.List;

public class ContactCreationTest extends TestBase {

    @Test
    public void testContactCreation() throws Exception {

        List<ContactData> before = app.getContactHelper().getContactList();
        app.getContactHelper().goToContactCreation();
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
        ), true);
        app.getNavigationHelper().goToHomePage();
        List<ContactData> after = app.getContactHelper().getContactList();
        Assert.assertEquals(after.size(), before.size()+1);
    }
}