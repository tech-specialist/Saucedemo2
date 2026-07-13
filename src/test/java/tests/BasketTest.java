package tests;

import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class BasketTest extends BaseTest {
    @Test
    public void checkGoodsAdded() {
        List<String> goodsList =
                List.of(
                        "Sauce Labs Bolt T-Shirt",
                        "Sauce Labs Bike Light",
                        "Test.allTheThings() T-Shirt (Red)");
        System.out.println("BasketTest is running in Thread: "
                + Thread.currentThread().getId());
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");

        assertEquals(productsPage.getTitle(), "Products", "Заголовок страницы не соответствует");

        for (String goods : goodsList) {
            productsPage.addGoodsToCart(goods);
        }

        productsPage.switchToBasket();
        assertTrue(basketPage.getProductsNames().equals(goodsList));
    }
}
