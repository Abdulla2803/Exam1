package pl.coderslab.Mystore;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserAuthPage {

    @FindBy(id = "email_create")
    private WebElement newUserEmailInput;

    @FindBy(id = "SubmitCreate")
    private WebElement createNewAccountBtn;

    @FindBy(name = "email")
    private WebElement loginEmailInput;

    @FindBy(name = "password")
    private WebElement loginPasswdInput;

    @FindBy(id = "submit-login")
    private WebElement loginBtn;

    public UserAuthPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void enterNewUserEmailAndSubmit(String email) {
        newUserEmailInput.clear();
        newUserEmailInput.sendKeys(email);

        createNewAccountBtn.click();
    }

    public void loginAs(String email, String passwd) {
        loginEmailInput.clear();
        loginEmailInput.sendKeys(email);

        loginPasswdInput.clear();
        loginPasswdInput.sendKeys(passwd);

        loginBtn.click();
    }
}

