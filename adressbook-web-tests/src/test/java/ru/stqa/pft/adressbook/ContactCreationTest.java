package ru.stqa.pft.adressbook;

import org.testng.annotations.Test;

public class ContactCreationTest extends TestBase {

   @Test
  public void testContactCreation() throws Exception {

    goToContactCreation();
    fillContactForm(new ContactData("firstName", "middleName", "lastName", "nickName", "testTitle", "testCompany", "test address", "1", "+23456789", "+12345677", "n/a", "test@test.com", "n/a", "18", "December", "1990", "secondary address", "secondaryHome", "test1"));
    saveContact();
    goToHomePage();
    logout();
  }

}