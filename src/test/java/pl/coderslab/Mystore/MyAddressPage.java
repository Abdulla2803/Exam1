package pl.coderslab.Mystore;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyAddressPage {
    public final WebDriver driver;
    @FindBy(id = "field-address1")
    private WebElement addressInput;

    @FindBy(id = "pfield-postcode")
    private WebElement postalCodeInput;

    @FindBy(id = "field-city")
    private WebElement cityInput;

    @FindBy(id = "field-phone")
    private WebElement phoneNumberInput;

    @FindBy(xpath = "//*[@id=\"content\"]/div/div/form/footer/button")
    private WebElement saveBtn;

    public MyAddressPage (WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void enterNewAddressData(String address, String city, String postalCode, String phoneNumber) {
        addressInput.clear();
        addressInput.sendKeys(address);

        cityInput.clear();
        cityInput.sendKeys(city);

        postalCodeInput.clear();
        postalCodeInput.sendKeys(postalCode);

        phoneNumberInput.clear();
        phoneNumberInput.sendKeys(phoneNumber);

        saveBtn.click();
    }
}

