//package pl.coderslab.Mystore2;
//
//import io.cucumber.java.en.And;
//import io.cucumber.java.en.Given;
//import io.cucumber.java.en.Then;
//import io.cucumber.java.en.When;
//import org.junit.jupiter.api.Assertions;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.support.FindBy;
//import org.openqa.selenium.support.PageFactory;
//import pl.coderslab.Mystore.MystoreMyAddressPage;
//import pl.coderslab.Mystore.UserAuthPage;
//
//import java.time.Duration;
//
//public class MyPageObjectsSteps {
//    private WebDriver driver;
//    private MystoreAuthPage authPage;
//    private MystoreMyAddressPage myAddressPage;
//
//    @Given("I'm on the Mystore authentication page")
//    public void userIsLoginToAccount() {
//        driver = new ChromeDriver();
//        driver.manage().window().maximize();
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//        driver.get("https://mystore-testlab.coderslab.pl/index.php?controller=authentication&back=my-account");
//    }
//
//    @When("I sign in using {string} and {string}")
//    public void iLoginUsingAnd(String signin, String passwd) {
//        authPage = new MystoreAuthPage(driver);
//        authPage.loginAs(signin, passwd);
//    }
//
//    @And("I go to Mystore hompage")
//    public void iGoToMystoreHomePage() {
//        myAddressPage = new MyStoreHomePage(driver);
//        myAddressPage.goToMyStoreHomePage();
//    }
//
//import io.cucumber.java.en.Then;
//
//@Then("I choose sweater Hummingbird Printed Sweater")
//    public void iChooseSweater() {
//        Assertions.assertTrue(MyStoreHomePage.MystoreHomePage.productadded(), "Sweater should be choosen");
//    }
//
//import io.cucumber.java.en.Then;
//
//@And("I choose size M")
//    public void iChooseSizeM() {
//        myAddressPage = new MyStoreHomePage(driver);
//        myAddressPage.goToMyAddressesPage();
//    }
//
//    @And("I increase amount of the product to 5")
//    public void iIncreaseAmountTo5() {
//        myAddressPage = new MyStoreHomePage(driver);
//        myAddressPage.goToMyAddressesPage();
//
//        @Then("I click on the Add to cart button")
//        public void iClickOnTheAddToCartBtn () {
//            Assertions.assertTrue(MyStoreHomePage.MystoreHomePage.productadded(), "Sweater should be choosen");
//
//
//        }