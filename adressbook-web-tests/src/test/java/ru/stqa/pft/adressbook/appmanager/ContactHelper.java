package ru.stqa.pft.adressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.stqa.pft.adressbook.model.ContactData;
import ru.stqa.pft.adressbook.model.Contacts;

import java.util.List;

import static org.openqa.selenium.By.cssSelector;

public class ContactHelper extends HelperBase {

    public ContactHelper(WebDriver wd) {
        super(wd);
    }

    public void fillContactForm(ContactData contactData, boolean creation) {
        type(By.name("firstname"), contactData.getFirstName());
        type(By.name("middlename"), contactData.getMiddleName());
        type(By.name("lastname"), contactData.getLastName());
        type(By.name("nickname"), contactData.getNickName());
        type(By.name("title"), contactData.getTitle());
        type(By.name("company"), contactData.getCompany());
        type(By.name("address"), contactData.getAddress());
        type(By.name("home"), contactData.getHome());
        type(By.name("mobile"), contactData.getMobilePhone());
        type(By.name("work"), contactData.getWorkPhone());
        type(By.name("fax"), contactData.getFax());
        type(By.name("email"), contactData.getEmail());
        type(By.name("homepage"), contactData.getHomepage());
        new Select(wd.findElement(By.name("bday"))).selectByVisibleText(contactData.getBirthDay());
        new Select(wd.findElement(By.name("bmonth"))).selectByVisibleText(contactData.getBirthMonth());
        wd.findElement(By.name("byear")).clear();
        wd.findElement(By.name("byear")).sendKeys(contactData.getBirthYear());
        if (creation) {
            new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(contactData.getSelectGroup());
        } else {
            Assert.assertFalse(isElementPresent(By.name("new_group")));
        }

        type(By.name("address2"), contactData.getSecondaryAddress());
        type(By.name("phone2"), contactData.getSecondaryHome());

    }

    public boolean isElementPresent(By locator) {
        try {
            wd.findElement(locator);
            return true;
        } catch (NoSuchElementException ex) {
            return false;
        }

    }

    public void saveContact() {
        click(By.xpath("(//input[@name='submit'])[2]"));
    }

    public void delete(ContactData contact) {
        selectContactById(contact.getId());
        clickDeleteContact();
        contactCash = null;
    }

    public void clickDeleteContact() {
        click(By.xpath("//input[@value='Delete']"));
    }

    public void selectContact(int i) {
        wd.findElements(By.name("selected[]")).get(i).click();
    }

    public int count() {
        return wd.findElements(By.name("selected[]")).size();
    }

    public void selectContactById(int id) {
        wd.findElement(cssSelector("input[value='" + id + "']")).click();
    }

  //  public void initContactModification(int i) {
  //      wd.findElements(By.cssSelector("[title='Edit']")).get(i).click();
  //  }

    public void initContactModification() {
        click(By.cssSelector("[title='Edit']"));
    }

    public void submitContactModification() {
        //      click(By.xpath("//input[@name='update'])[2]"));
        click(By.name("update"));
    }

    public void goToContactCreation() {
        click(By.linkText("add new"));
    }

    public void create(ContactData contactData, boolean b) {
        goToContactCreation();
        fillContactForm(contactData, b);
        saveContact();
        contactCash = null;
    }

  /*  public void modify(int index, ContactData contact) {
        initContactModification(index);
        fillContactForm(contact, false);
        submitContactModification();
    }*/

    public void modify(ContactData contact) {
        selectContactById(contact.getId());
        initContactModification();
        fillContactForm(contact, false);
        submitContactModification();
        contactCash = null;
    }

    public int getContactCount() {
        return wd.findElements(By.name("selected[]")).size();
    }

    private Contacts contactCash = null;

    public Contacts all() {
        if (contactCash!=null){
            return new Contacts(contactCash);
        }
        contactCash = new Contacts();
        List<WebElement> elements = wd.findElements(By.name("entry"));
        for (WebElement element : elements) {
            String lastName = element.findElement(By.xpath("td[2]")).getText();
            String firstName = element.findElement(By.xpath("td[3]")).getText();
            int id = Integer.parseInt(element.findElement(cssSelector("input[name='selected[]']")).getAttribute("id"));
            ContactData contact = new ContactData(id, firstName, null, lastName,null,null, null,null,null,null,null,null,null,null,null,null,null,null,null,null);
            contactCash.add(contact);
        }
        return new Contacts(contactCash);
    }
}