package pl.coderslab.Mystore;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class UserPageObjectSteps {
    private WebDriver driver;
    private UserAuthPage authPage;
    private MystoreMyAddressPage myAddressPage;

    @Given("I'm on the hotel authentication page")
    public void userIsLoginToAccount() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://mystore-testlab.coderslab.pl/index.php?controller=authentication&back=my-account");
    }

    @When("I sign in using {string} and {string}")
    public void iLoginUsingAnd(String signin, String passwd) {
        authPage = new UserAuthPage(driver);
        authPage.loginAs(signin, passwd);
    }

    @And("I go to my addresses page")
    public void iGoToMyAddressPage() {
        AccountPage myAccountPage = new AccountPage(driver);
        myAccountPage.goToMyAddressPage();
        MystoreMyAddressPage myAddressesPage = new MystoreMyAddressPage(driver);
    }

    @When("I add new address")
    public void clickingAddNewAddress() {
        driver.findElement(By.cssSelector("#content > div.addresses-footer > a > span")).click();
    }

    @And("I enter new address {string}, {string}, {string}, {string}")
    public void iEnterNewAddress(String alias, String address, String city, String postCode, String phone) {
        MystoreMyAddressPage x = new MystoreMyAddressPage(driver);
        x.enterNewAddress(alias, address, city, postCode, phone);
    }


    @Then("I can see new address")
    public void iCanSeeNewAddress() {
        MyAddressPage myAddress = new MyAddressPage(driver);
        Assert.assertNotNull(myAddress.alert);
        Assert.assertTrue(myAddress.isAlertVisible());
    }

    @And("I verify created address {string}, {string}, {string}, {string}")
    public void verifyAddress(String alias, String address, String city, String postCode, String phone) {
        MyAddressPage myAddress = new MyAddressPage(driver);
        String[] l = myAddress.address.findElement(By.tagName("address")).getText().split("\n");
        String aliasFromPage = myAddress.address.findElement(By.tagName("h4")).getText();
        Assert.assertEquals(aliasFromPage, alias);
        Assert.assertEquals(l[1], address);
        Assert.assertEquals(l[2], city);
        Assert.assertEquals(l[3], postCode);
        Assert.assertEquals(l[5], phone);
    }
    @And("I close the browser")
    public void iCloseTheBrowser() {
        driver.quit();
    }
}
