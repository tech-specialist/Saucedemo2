package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private final By loginInput = By.xpath("//*[@placeholder='Username']");
    private final By passwordInput = By.xpath("//*[@placeholder='Password']");
    private final By submitButton = By.cssSelector("#login-button");
    WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void open() {
        driver.get("https://www.saucedemo.com/");
    }

    public void login(String login, String password) {
        driver.findElement(loginInput).sendKeys(login);
        driver.findElement(passwordInput).sendKeys(password);
        driver.findElement(submitButton).click();
    }
}
