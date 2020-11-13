package ru.stqa.pft.adressbook.tests;


import org.testng.annotations.*;

import static org.testng.Assert.*;

import org.openqa.selenium.*;
import ru.stqa.pft.adressbook.tests.TestBase;

public class ContactDeletionTest extends TestBase {

    @Test
    public void testContactDeletion() throws Exception {
        app.goToHomePage();
        selectContact();
        app.acceptNextAlert = true;
        clickDeleteContact();
        assertTrue(app.closeAlertAndGetItsText().matches("^Delete 1 addresses[\\s\\S]$"));
        app.logout();
    }

    public void clickDeleteContact() {
        app.wd.findElement(By.xpath("//input[@value='Delete']")).click();
    }

    public void selectContact() {
        app.wd.findElement(By.name("selected[]")).click();
    }

}
