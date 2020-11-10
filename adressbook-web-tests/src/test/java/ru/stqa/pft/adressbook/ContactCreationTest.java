package ru.stqa.pft.adressbook;

import java.util.concurrent.TimeUnit;
import org.testng.annotations.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class ContactCreationTest {
  private WebDriver wd;


  @BeforeMethod(alwaysRun = true)
  public void setUp() throws Exception {
    wd = new FirefoxDriver();
    wd.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    wd.get("http://localhost/adressbook/group.php");
    login("admin", "secret");
  }

  @Test
  public void testContactCreation() throws Exception {

    goToContactCreation();
    fillContactForm(new ContactData("firstName", "middleName", "lastName", "nickName", "testTitle", "testCompany", "test address", "1", "+23456789", "+12345677", "n/a", "test@test.com", "n/a", "18", "December", "1990", "secondary address", "secondaryHome", "test1"));
    saveContact();
    goToHomePage();
    logout();
  }

  private void fillContactForm(ContactData contactData) {
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

  private void logout() {
    wd.findElement(By.linkText("Logout")).click();
  }

  private void goToHomePage() {
    wd.findElement(By.linkText("home")).click();
  }

  private void saveContact() {
    wd.findElement(By.xpath("(//input[@name='submit'])[2]")).click();
  }

  private void goToContactCreation() {
    wd.findElement(By.linkText("add new")).click();
  }

  private void login(String username, String password) {
    wd.findElement(By.name("user")).clear();
    wd.findElement(By.name("user")).sendKeys(username);
    wd.findElement(By.name("pass")).clear();
    wd.findElement(By.name("pass")).sendKeys(password);
    wd.findElement(By.xpath("//input[@value='Login']")).click();
  }

  @AfterMethod(alwaysRun = true)
  public void tearDown() throws Exception {
    wd.quit();

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

}
