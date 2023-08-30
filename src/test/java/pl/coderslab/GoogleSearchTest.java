package pl.coderslab;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/Cucumber/Features/Mystore-account-login.feature",
        plugin = {"pretty", "html:out.html"})
public class GoogleSearchTest {
}
