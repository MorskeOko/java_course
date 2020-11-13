package ru.stqa.pft.adressbook.appmanager;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import ru.stqa.pft.adressbook.model.ContactData;
import ru.stqa.pft.adressbook.model.GroupData;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {
    public boolean acceptNextAlert = true;
    public FirefoxDriver wd;

    public void init() {
        wd = new FirefoxDriver();
        wd.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        wd.get("http://localhost/adressbook/group.php");
        login("admin", "secret");
    }

    public void stop() {
        wd.quit();
    }

    private void login(String username, String password) {
        wd.findElement(By.name("user")).clear();
        wd.findElement(By.name("user")).sendKeys(username);
        wd.findElement(By.name("pass")).clear();
        wd.findElement(By.name("pass")).sendKeys(password);
        wd.findElement(By.xpath("//input[@value='Login']")).click();
    }

    public void logout() {
        wd.findElement(By.linkText("Logout")).click();
    }

    public void submitGroupCreation() {
        wd.findElement(By.name("submit")).click();
    }

    public void fillGroupForm(GroupData groupData) {
        wd.findElement(By.name("group_name")).clear();
        wd.findElement(By.name("group_name")).sendKeys(groupData.getGroupName());
        wd.findElement(By.name("group_header")).clear();
        wd.findElement(By.name("group_header")).sendKeys(groupData.getGroupHeader());
        wd.findElement(By.name("group_footer")).clear();
        wd.findElement(By.name("group_footer")).sendKeys(groupData.getGroupFooter());
    }

    public void gotoGroupPage() {
        wd.findElement(By.linkText("groups")).click();
    }

    public void initGroupCreation() {
        wd.findElement(By.name("new")).click();
    }

    private boolean isElementPresent(By by) {
        try {
            wd.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    private boolean isAlertPresent() {
        try {
            wd.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }

    public void deleteSelectedGroups() {
        wd.findElement(By.name("delete")).click();
    }

    public void selectGroup() {
        wd.findElement(By.name("selected[]")).click();
    }

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

    public void goToHomePage() {
      wd.findElement(By.linkText("home")).click();
    }

    public void saveContact() {
      wd.findElement(By.xpath("(//input[@name='submit'])[2]")).click();
    }

    public void goToContactCreation() {
      wd.findElement(By.linkText("add new")).click();
    }

    public String closeAlertAndGetItsText() {
        try {
            Alert alert = wd.switchTo().alert();
            String alertText = alert.getText();
            if (acceptNextAlert) {
                alert.accept();
            } else {
                alert.dismiss();
            }
            return alertText;
        } finally {
            acceptNextAlert = true;
        }
    }
}
