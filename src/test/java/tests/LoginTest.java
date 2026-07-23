package tests;

import io.qameta.allure.*;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utils.AllureUtils;

import static enums.TitleNaming.PRODUCTS;
import static org.testng.Assert.assertEquals;
import static user.UserFactory.withAdminPermission;

@Epic("Блок онлайн оплаты")
@Feature("Оплата банк картой")
@Owner("Belov Dmitry Vladimirovich belov@gmail.com")
public class LoginTest extends BaseTest {


    @Story("Ввод персональных данных")
    @Severity(SeverityLevel.BLOCKER)
    @TmsLink("Saucedemo2")
    @Issue("Blanchard")
    @Test(description = "Проверка корректной авторизации", priority = 1)
    public void checkLogin() {
        System.out.println("LoginTest.checkLogin is running in Thread: "
                + Thread.currentThread().getId());
        loginPage.open();
        loginPage.login(withAdminPermission());

        assertEquals(productsPage.getTitle(), PRODUCTS.getDisplayName(), "Заголовок страницы не соответствует");

    }

    @DataProvider(name = "incorrectLoginData")
    public Object[][] loginData() {
        return new Object[][]{
                {"", "secret_sauce", "Epic sadface: Username is required"},
                {"standard_user", "", "Epic sadface: Password is required"},
                {"Standard_user", "secret_sauce", "Epic sadface: Username and password do not match any user in this service"},
                {"locked_out_user", "secret_sauce", "Epic sadface: Sorry, this user has been locked out."}
        };
    }

/*        @Test(dataProvider = "incorrectLoginData", dependsOnMethods = "checkLogin", priority = 2)
    public void checkIncorrectLogin(String user, String password, String errorMessage) {
        System.out.println("LoginTest.checkIncorrectLogin is running in Thread: "
                + Thread.currentThread().getId());
        loginPage.open();
        loginPage.login(user, password);

        assertTrue(loginPage.isErrorDisplayed());
        assertEquals(loginPage.getErrorText(), errorMessage);
    }
 */
}
