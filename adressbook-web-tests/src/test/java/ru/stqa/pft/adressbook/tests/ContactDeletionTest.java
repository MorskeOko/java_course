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
            app.contact().create(new ContactData("firstName",
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
        Contacts after = app.contact().all();
        assertThat(after.size(), equalTo(before.size()-1));
        before.remove(deletedContact);
        assertThat(after, equalTo(before.withOut(deletedContact)));
    }
}
