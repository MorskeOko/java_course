package ru.stqa.pft.adressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.adressbook.model.ContactData;
import java.util.Comparator;
import java.util.List;

public class ContactModificationTest extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        app.goTo().homePage();
        if (app.contact().list().size()==0) {
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
            ), true);
        }
        app.goTo().homePage();
    }

    @Test
    public void testContactModification() throws Exception {
        List<ContactData> before = app.contact().list();
        int index = before.size() - 1;
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
        app.contact().modify(index, contact);
        app.goTo().homePage();
        List<ContactData> after = app.contact().list();
        Assert.assertEquals(after.size(), before.size());
        contact.setId(after.stream().max((o1, o2) -> Integer.compare(o1.getId(), o2.getId())).get().getId());
        before.remove(index);
        before.add(contact);
        Comparator<? super ContactData> byId = (c1, c2) -> Integer.compare(c1.getId(), c2.getId());
        before.sort(byId);
        after.sort(byId);
        Assert.assertEquals(before, after);
    }
}