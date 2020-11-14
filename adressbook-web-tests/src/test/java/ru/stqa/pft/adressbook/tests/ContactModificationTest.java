package ru.stqa.pft.adressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.adressbook.model.ContactData;

public class ContactModificationTest extends TestBase {

    @Test
    public void testContactDeletion() throws Exception {
        app.getNavigationHelper().goToHomePage();
        app.getContactHelper().initContactModification();
        app.getContactHelper().fillContactForm(new ContactData("firstNameModified", "middleName", "lastName", "nickName", "testTitle", "testCompany", "test address", "1", "+23456789", "+12345677", "n/a", "test@test.com", "n/a", "18", "December", "1990", "secondary address", "secondaryHome", "test1"));
        app.getContactHelper().submitContactModification();
        app.getNavigationHelper().goToHomePage();
    }
}