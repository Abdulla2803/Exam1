package pl.coderslab.Mystore2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginExam2 {
    public LoginExam2(WebDriver driver) {
        this.driver = driver;

        private final WebDriver driver;
        private final WebDriverWait wait;

        public LoginExam2(WebDriver driver) {
            this.driver = driver;
            this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        }


    public boolean loginAs(String email, String password) {
            WebElement loginInput = driver.findElement(By.name("email"));
            loginInput.click();
            loginInput.clear();
            loginInput.sendKeys(email);

            WebElement passwordInput = driver.findElement(By.name("password"));
            passwordInput.click();
            passwordInput.clear();
            passwordInput.sendKeys(password);

            WebElement signInButton = driver.findElement(By.id("submit-login"));
            signInButton.click();


            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class='account']")));

            return isLoggedIn();
        }

        private boolean isLoggedIn() {
            // Verify if the user is logged in
            WebElement accountLink = driver.findElement(By.xpath("//a[@class='account']"));
            return accountLink.isDisplayed();
        }

        public String getLoggedUsername() {
            WebElement userName = driver.findElement(By.xpath("//a[@class='account']"));
            return userName.getText();
        }
    }

