package pl.coderslab.Mystore;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
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
        public void iGoToMyAddressesPage() {
            myAddressPage = new MystoreMyAddressPage(driver);
            myAddressPage.goToMyAddressesPage();
        }

        @Then("I can see there is no addresses")
        public void iCanSeeThereIsNoAddresses() {
            Assertions.assertFalse(myAddressPage.addressIsVisible(), "No addresses should be visible");
        }

        @When("I add new address")
        public void iAddNewAddress() {
            myAddressPage.addNewAddress();
        }

        @And("I enter new address {string}, {string}, {string}, {string}")
        public void iEnterNewAddress(String address, String postalCode, String city, String phoneNumber) {
            myAddressPage.enterNewAddressData(address, city, postalCode, phoneNumber);
        }

        @Then("I can see new address")
        public void iCanSeeNewAddress() {
            Assertions.assertTrue(myAddressPage.addressIsVisible(), "Created address should be visible");
        }

        @And("I close the browser")
        public void iCloseTheBrowser() {
            driver.quit();
        }

        @And("I verify created address {string}, {string}, {string}, {string}")
        public void iVerifyCreatedAddress(String address, String postalCode, String city, String phoneNumber) {
            String addressAsText = myAddressPage.getFirstAddressAsText();
            String expectedAddress = String.join("\n", address, postalCode + " " + city, phoneNumber);
            Assertions.assertEquals(expectedAddress, addressAsText);
        }
    }
