import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

public class LoginTest extends BaseTest {

    @Test
    public void checkLogin() {
        driver.findElement(By.xpath("//*[@placeholder='Username']")).sendKeys("standard_user");
        driver.findElement(By.xpath("//*[@placeholder='Username']")).sendKeys(Keys.CONTROL + "A");
        driver.findElement(By.xpath("//*[@placeholder='Username']")).sendKeys(Keys.BACK_SPACE);
        driver.findElement(By.xpath("//*[@placeholder='Username']")).sendKeys("standard_user");
        driver.findElement(By.xpath("//*[@placeholder='Password']")).sendKeys("secret_sauce");
        driver.findElement(By.cssSelector("#login-button")).click();
        String titleName = driver.findElement(By.xpath("//*[@class='title']")).getText();

        assertEquals(titleName, "Products", "Заголовок страницы не соответствует");
    }

    @Test
    public void checkIncorrectLogin() {
        driver.findElement(By.xpath("//*[@placeholder='Username']")).sendKeys("");
        driver.findElement(By.xpath("//*[@placeholder='Password']")).sendKeys("secret_sauce");
        driver.findElement(By.cssSelector("#login-button")).click();
        boolean isTitleVisible = driver.findElement(By.xpath("//h3[@data-test='error']")).isDisplayed();
        String errorText = driver.findElement(By.xpath("//h3[@data-test='error']")).getText();

        assertTrue(isTitleVisible);
        assertEquals(errorText, "Epic sadface: Username is required");
    }
}
