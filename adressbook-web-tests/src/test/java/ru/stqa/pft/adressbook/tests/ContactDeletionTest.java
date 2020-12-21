package ru.stqa.pft.adressbook.tests;


import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.adressbook.model.ContactData;
import ru.stqa.pft.adressbook.model.Contacts;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.testng.Assert.assertTrue;

public class ContactDeletionTest extends TestBase {

    @BeforeMethod
    public void ensurePreconditions(){
        app.goTo().homePage();
        if (app.contact().all().size()==0) {
            app.contact().create(new ContactData()
                            .withFirstName("TheFirstName")
                            .withMiddleName("middleName")
                            .withLastName("lastName")
                            .withTitle("testTitle")
                            .withCompany("testCompany")
                            .withAddress("test address")
                            .withHomePhone("1")
                            .withMobilePhone("+23456789")
                            .withWorkPhone("+12345677")
                            .withEmail("test@test.com")
                            .witBirthDay("18")
                            .withBirthMonth("December")
                            .withBirthYear("1990")
                            .withSecondaryAddress("TheTest2")
                            .withSecondaryHome("secondaryHome")
                            .withSelectGroup("TheTest2") , true);
        }
        app.goTo().homePage();
    }

    @Test
    public void testContactDeletion() throws Exception {
        Contacts before = app.contact().all();
        ContactData deletedContact = before.iterator().next();
        app.contact().delete(deletedContact);
        app.acceptNextAlert = true;
        assertTrue(app.closeAlertAndGetItsText().matches("^Delete 1 addresses[\\s\\S]$"));
        app.goTo().homePage();
        assertThat(app.contact().count(), equalTo(before.size()-1));
        Contacts after = app.contact().all();
        before.remove(deletedContact);
        assertThat(after, equalTo(before.withOut(deletedContact)));
    }
}
