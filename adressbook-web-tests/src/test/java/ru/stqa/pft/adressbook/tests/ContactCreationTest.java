package ru.stqa.pft.adressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.adressbook.model.ContactData;

public class ContactCreationTest extends TestBase {

   @Test
  public void testContactCreation() throws Exception {

    app.goToContactCreation();
    app.fillContactForm(new ContactData("firstName", "middleName", "lastName", "nickName", "testTitle", "testCompany", "test address", "1", "+23456789", "+12345677", "n/a", "test@test.com", "n/a", "18", "December", "1990", "secondary address", "secondaryHome", "test1"));
    app.saveContact();
    app.goToHomePage();
    app.logout();
  }

}