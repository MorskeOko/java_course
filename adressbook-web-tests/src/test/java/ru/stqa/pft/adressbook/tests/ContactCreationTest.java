package ru.stqa.pft.adressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.adressbook.model.ContactData;
import ru.stqa.pft.adressbook.model.Contacts;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

public class ContactCreationTest extends TestBase {

    @Test
    public void testContactCreation() throws Exception {
        app.goTo().homePage();
        Contacts before = app.contact().all();
        app.contact().goToContactCreation();
        ContactData contact = new ContactData()
                .withFirstName("TheFirstName")
                .withMiddleName("middleName")
                .withLastName("lastName")
                .withTitle("testTitle")
                .withCompany("testCompany")
                .withAddress("test address")
                .withHome("1")
                .withMobilePhone("+23456789")
                .withWorkPhone("+12345677")
                .withEmail("test@test.com")
                .witBirthDay("18")
                .withBirthMonth("December")
                .withBirthYear("1990")
                .withSecondaryAddress("TheTest2")
                .withSecondaryHome("secondaryHome")
                .withSelectGroup("TheTest2");

        app.contact().create(contact, true);
        app.goTo().homePage();
        assertThat(app.contact().count(), equalTo(before.size()+1));
        Contacts after = app.contact().all();
        before.add(contact);
        contact.withId(after.stream().mapToInt((g)-> g.getId()).max().getAsInt());
        assertThat(after, equalTo(before.withAdded(contact)));
    }
}