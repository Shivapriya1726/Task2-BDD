package StepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.And;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.junit.Assert;

public class Steps {

    private WebDriver driver;

    @Given("User is on Home Page")
    public void user_is_on_login_page() {
        // Set up Chrome WebDriver
        System.setProperty("webdriver.chrome.driver", "D://chromedriver-win64//chromedriver-win64//chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        driver = new ChromeDriver(options);
        driver.get("https://practicetestautomation.com/practice-test-login/");
    }

    @When("User enters {string} and {string}")
    public void user_enters_username_and_password(String username, String password) {
        WebElement usernameField = driver.findElement(By.id("username"));
        usernameField.sendKeys(username);

        WebElement passwordField = driver.findElement(By.id("password"));
        passwordField.sendKeys(password);

        WebElement loginButton = driver.findElement(By.id("submit"));
        loginButton.click();
    }

    @And("Keeping case as Valid")
    public void keeping_case_as_valid() {
        // No specific action required for this step
    }
    @Then("User should get logged in")
    public void user_should_get_logged_in() {
        String currentURL = driver.getCurrentUrl();
        String expectedURL = "https://practicetestautomation.com/logged-in-successfully/";
        assert currentURL.equals(expectedURL) : "Login Failed";

    }
    @Then("User log out successfully")
    public void user_log_out_successfully(){
        WebElement logoutLink = driver.findElement(By.linkText("Log out"));
        logoutLink.click();
        driver.quit();
    }

    @When("User enters Invalid {string} and {string}")
    public void user_enters_invalid_and(String string, String string2) {
        WebElement usernameField = driver.findElement(By.id("username"));
        usernameField.sendKeys(string);

        WebElement passwordField = driver.findElement(By.id("password"));
        passwordField.sendKeys(string2);

        WebElement loginButton = driver.findElement(By.id("submit"));
        loginButton.click();
    }
    @When("Keeping case as Invalid")
    public void keeping_case_as_invalid() {
        //pass
    }
    @Then("User will be asked to go back to the login page")
    public void user_will_be_asked_to_go_back_to_the_login_page() {

    }
    @Then("Provide correct credentials")
    public void provide_correct_credentials() {
        WebElement usernameField = driver.findElement(By.id("username"));
        usernameField.sendKeys("student");

        WebElement passwordField = driver.findElement(By.id("password"));
        passwordField.sendKeys("Password123");

        WebElement loginButton = driver.findElement(By.id("submit"));
        loginButton.click();

    }
}
