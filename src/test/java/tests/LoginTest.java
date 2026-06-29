package tests;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

public class LoginTest extends BaseTest {

    @Test
    public void checkLogin() throws InterruptedException {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        Thread.sleep(5000);

        assertEquals(productsPage.getTitle(), "Products", "Заголовок страницы не соответствует");
    }

    @Test
    public void checkEmptyLogin() {
        loginPage.open();
        loginPage.login("","secret_sauce");

        assertTrue(loginPage.isErrorDisplayed());
        assertEquals(loginPage.getErrorText(), "Epic sadface: Username is required");
    }

    @Test
    public void checkEmptyPasswordLogin() {
        loginPage.open();
        loginPage.login("standard_user","");

        assertTrue(loginPage.isErrorDisplayed());
        assertEquals(loginPage.getErrorText(), "Epic sadface: Password is required");
    }

    @Test
    public void checkCapsLockLogin() {
        loginPage.open();
        loginPage.login("Standard_user","secret_sauce");

        assertTrue(loginPage.isErrorDisplayed());
        assertEquals(loginPage.getErrorText(), "Epic sadface: Username and password do not match any user in this service");
    }

    @Test
    public void checkLockedUser() {
        loginPage.open();
        loginPage.login("locked_out_user","secret_sauce");

        assertTrue(loginPage.isErrorDisplayed());
        assertEquals(loginPage.getErrorText(), "Epic sadface: Sorry, this user has been locked out.");
    }
}
