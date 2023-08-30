package pl.coderslab.Mystore;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class MystoreMyAddressPage {
    private final WebDriver driver;

    public MystoreMyAddressPage (WebDriver driver) {
        this.driver = driver;
    }


    @FindBy(xpath = "//*[@id=\"footer_account_list\"]/li[4]/a")
    private WebElement addressLink;

    @FindBy(xpath = "//*[@id=\"content\"]/div[2]/a/span")
    private WebElement createNewAddressButton;

    @FindBy(className = "address_address1")
    private List<WebElement> addressLines;

    @FindBy(className = "address_city")
    private List<WebElement> addressCities;

    @FindBy(className = "address_phone_mobile")
    private List<WebElement> addressPhoneMobiles;


    public boolean addressIsVisible() {
        return !addressLines.isEmpty();
    }

    public void addNewAddress() {
        createNewAddressButton.click();
    }

    public String getFirstAddressAsText() {
        String addressText = addressLines.get(0).getText();
        String cityAndPostal = addressCities.get(0).getText();
        String phoneMobile = addressPhoneMobiles.get(0).getText();
        return String.join("\n", addressText, cityAndPostal, phoneMobile);
    }

    public void enterNewAddressData(String address, String city, String postalCode, String phoneNumber) {
    }

    public void goToMyAddressesPage() {
    }
}