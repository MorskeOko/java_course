package ru.stqa.pft.adressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import ru.stqa.pft.adressbook.model.ContactData;

public class ContactHelper {
    private FirefoxDriver wd;

    public ContactHelper(FirefoxDriver wd) {
        this.wd=wd;    }

    public void fillContactForm(ContactData contactData) {
      wd.findElement(By.name("firstname")).clear();
      wd.findElement(By.name("firstname")).sendKeys(contactData.getFirstName());
      wd.findElement(By.name("middlename")).clear();
      wd.findElement(By.name("middlename")).sendKeys(contactData.getMiddleName());
      wd.findElement(By.name("lastname")).clear();
      wd.findElement(By.name("lastname")).sendKeys(contactData.getLastName());
      wd.findElement(By.name("nickname")).clear();
      wd.findElement(By.name("nickname")).sendKeys(contactData.getNickName());
      wd.findElement(By.name("title")).clear();
      wd.findElement(By.name("title")).sendKeys(contactData.getTitle());
      wd.findElement(By.name("company")).clear();
      wd.findElement(By.name("company")).sendKeys(contactData.getCompany());
      wd.findElement(By.name("address")).clear();
      wd.findElement(By.name("address")).sendKeys(contactData.getAddress());
      wd.findElement(By.name("home")).clear();
      wd.findElement(By.name("home")).sendKeys(contactData.getHome());
      wd.findElement(By.name("mobile")).clear();
      wd.findElement(By.name("mobile")).sendKeys(contactData.getMobilePhone());
      wd.findElement(By.name("work")).clear();
      wd.findElement(By.name("work")).sendKeys(contactData.getWorkPhone());
      wd.findElement(By.name("fax")).clear();
      wd.findElement(By.name("fax")).sendKeys(contactData.getFax());
      wd.findElement(By.name("email")).clear();
      wd.findElement(By.name("email")).sendKeys(contactData.getEmail());
      wd.findElement(By.name("homepage")).clear();
      wd.findElement(By.name("homepage")).sendKeys(contactData.getHomepage());
      new Select(wd.findElement(By.name("bday"))).selectByVisibleText(contactData.getBirthDay());
      new Select(wd.findElement(By.name("bmonth"))).selectByVisibleText(contactData.getBirthMonth());
      wd.findElement(By.name("byear")).clear();
      wd.findElement(By.name("byear")).sendKeys(contactData.getBirthYear());
      new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(contactData.getSelectGroup());
      wd.findElement(By.name("address2")).clear();
      wd.findElement(By.name("address2")).sendKeys(contactData.getSecondaryAddress());
      wd.findElement(By.name("phone2")).clear();
      wd.findElement(By.name("phone2")).sendKeys(contactData.getSecondaryHome());
    }

    public void saveContact() {
      wd.findElement(By.xpath("(//input[@name='submit'])[2]")).click();
    }

    public void clickDeleteContact() {
        wd.findElement(By.xpath("//input[@value='Delete']")).click();
    }

    public void selectContact() {
        wd.findElement(By.name("selected[]")).click();
    }
}
