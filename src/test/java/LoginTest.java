import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;





public class LoginTest {
    @Test
    public void checkLogin () throws InterruptedException {
        //1. открыть браузер
        //2. зайти на сайт https://www.saucedemo.com/
        WebDriver browser = new ChromeDriver();
        browser.get("https://www.saucedemo.com/");
        browser.findElement(By.xpath("//*[@placeholder='Username']")).sendKeys("standard_user");
        browser.findElement(By.xpath("//*[@placeholder='Username']")).sendKeys(Keys.CONTROL + "A");
        browser.findElement(By.xpath("//*[@placeholder='Username']")).sendKeys(Keys.BACK_SPACE);
        browser.findElement(By.xpath("//*[@placeholder='Username']")).sendKeys("standard_user");
        browser.findElement(By.xpath("//*[@placeholder='Password']")).sendKeys("secret_sauce");
        browser.findElement(By.cssSelector("#login-button")).click();
        String titleName = browser.findElement(By.xpath("//*[@class='title']")).getText();
        asserEquals(titleName, "Products", "Заголовок страницы не соответствует");
    }
    private void asserEquals(String titleName, String products, String заголовокСтраницыНеСоответствует) {
    }


    @Test
    public void checkIncorrectLogin() {
        //1. открыть браузер
        //2. зайти на сайт https://www.saucedemo.com/
        WebDriver browser = new ChromeDriver();
        browser.get("https://www.saucedemo.com/");
        browser.findElement(By.xpath("//*[@placeholder='Username']")).sendKeys("");
        browser.findElement(By.xpath("//*[@placeholder='Password']")).sendKeys("secret_sauce");
        browser.findElement(By.cssSelector("#login-button")).click();

    }



}
