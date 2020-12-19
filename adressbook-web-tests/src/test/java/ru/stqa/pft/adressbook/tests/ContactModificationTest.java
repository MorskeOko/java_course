package ru.stqa.pft.adressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.adressbook.model.ContactData;

import java.util.Set;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

public class ContactModificationTest extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
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
                    "testNew",
                    "secondaryHome",
                    "secondary address"
            ), true);
        }
        app.goTo().homePage();
    }

    @Test
    public void testContactModification() throws Exception {
        Set<ContactData> before = app.contact().all();
        ContactData modifiedContact = before.iterator().next();
        ContactData contact = new ContactData("ChangedFirstName",
                "ChangedMiddleName",
                "ChangedLastName",
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
                null,
                "secondaryHome",
                "secondary address");
        app.contact().modify(contact);
        app.goTo().homePage();
        Set<ContactData> after = app.contact().all();
        assertThat(after.size(), equalTo(before.size()));
        contact.withId(after.stream().max((o1, o2) -> Integer.compare(o1.getId(), o2.getId())).get().getId());
        before.remove(modifiedContact);
        before.add(contact);
        assertThat(after, equalTo(before));
    }
}