package ru.stqa.pft.adressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.adressbook.model.ContactData;

import java.util.Set;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

public class ContactCreationTest extends TestBase {

    @Test
    public void testContactCreation() throws Exception {
        app.goTo().homePage();
        Set<ContactData> before = app.contact().all();
        app.contact().goToContactCreation();
        ContactData contact = new ContactData("TheFirstName",
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
                "testNew",
                "secondaryHome",
                "secondary address"
        );
        app.contact().create(contact, true);
        app.goTo().homePage();
        Set<ContactData> after = app.contact().all();
        assertThat(after.size(), equalTo(before.size()+1));
        before.add(contact);
        contact.withId(after.stream().mapToInt((g)-> g.getId()).max().getAsInt());
        assertThat(after, equalTo(before));
    }
}