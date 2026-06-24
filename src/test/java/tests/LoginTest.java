package tests;

import org.openqa.selenium.By;

import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

public class LoginTest extends BaseTest {

    @Test
    public void checkLogin() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");

        assertEquals(productsPage.getTitle(), "Products", "Заголовок страницы не соответствует");
    }


    @Test
    public void checkIncorrectLogin() {
        loginPage.open();
        loginPage.login("","secret_sauce");

        boolean isTitleVisible = driver.findElement(By.xpath("//h3[@data-test='error']")).isDisplayed();
        String errorText = driver.findElement(By.xpath("//h3[@data-test='error']")).getText();

        assertTrue(isTitleVisible);
        assertEquals(errorText, "Epic sadface: Username is required");
    }
}
