//package pl.coderslab.Mystore2;
//
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.support.FindBy;
//import org.openqa.selenium.support.PageFactory;
//
//public class MystoreAuthPage {
//    @FindBy(name = "email")
//    private WebElement loginEmailInput;
//
//    @FindBy(name = "password")
//    private WebElement loginPasswdInput;
//
//    @FindBy(id = "submit-login")
//    private WebElement loginBtn;
//
//    public MystoreAuthPage(WebDriver driver) {
//        PageFactory.initElements(driver, this);
//    }
//
//    public void loginAs(String email, String passwd) {
//        loginEmailInput.clear();
//        loginEmailInput.sendKeys(email);
//
//        loginPasswdInput.clear();
//        loginPasswdInput.sendKeys(passwd);
//
//        loginBtn.click();
//    }
//}
//
//