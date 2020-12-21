package ru.stqa.pft.adressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.adressbook.model.ContactData;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactPhoneTests extends  TestBase{

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
    public void TestContactPhones() {
        app.goTo().homePage();
        ContactData contact = app.contact().all().iterator().next();
        ContactData contactInfoFromEditForm = app.contact().infoFromEditForm(contact);
        assertThat(contact.getAllPhones(), equalTo(mergePhones(contactInfoFromEditForm)) );
        }

    private String mergePhones(ContactData contact) {
        return Arrays.asList(contact.getHomePhone(), contact.getMobilePhone(), contact.getWorkPhone())
                .stream().filter((s)->!s.equals(""))
                .map(ContactPhoneTests::cleaned)
                .collect(Collectors.joining("\n"));
}

    public static String cleaned (String phone) {
        return phone.replaceAll("\\s", "").replaceAll("[-()]","");
    }
}
