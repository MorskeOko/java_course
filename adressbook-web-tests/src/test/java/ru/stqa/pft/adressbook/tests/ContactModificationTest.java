package ru.stqa.pft.adressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.adressbook.model.ContactData;
import ru.stqa.pft.adressbook.model.Contacts;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

public class ContactModificationTest extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        app.goTo().homePage();
        if (app.contact().all().size()==0) {
            app.contact().create(new ContactData()
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
                    .withSelectGroup("TheTest2") , true);
        }
        app.goTo().homePage();
    }

    @Test
    public void testContactModification() throws Exception {
        Contacts before = app.contact().all();
        ContactData modifiedContact = before.iterator().next();
        ContactData contact = new ContactData()
                .withId(modifiedContact.getId())
                .withFirstName("ChangedFirstName")
                .withLastName("ChangedLastName")
                .witBirthDay("18")
                .withBirthMonth("December")
                .withBirthYear("1990");
        app.contact().modify(contact);
        app.goTo().homePage();
        assertThat(app.contact().count(), equalTo(before.size()));
        Contacts after = app.contact().all();
        contact.withId(after.stream().max((o1, o2) -> Integer.compare(o1.getId(), o2.getId())).get().getId());
        before.remove(modifiedContact);
        before.add(contact);
        assertThat(after, equalTo(before));
    }
}