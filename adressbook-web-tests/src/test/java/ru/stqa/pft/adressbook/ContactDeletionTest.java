package ru.stqa.pft.adressbook;


import org.testng.annotations.*;

import static org.testng.Assert.*;

import org.openqa.selenium.*;

public class ContactDeletionTest extends TestBase {

    @Test
    public void testContactDeletion() throws Exception {
        goToHomePage();
        wd.findElement(By.name("selected[]")).click();
        acceptNextAlert = true;
        wd.findElement(By.xpath("//input[@value='Delete']")).click();
        assertTrue(closeAlertAndGetItsText().matches("^Delete 1 addresses[\\s\\S]$"));
        logout();
    }

}
