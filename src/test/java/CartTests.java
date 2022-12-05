import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.HomePage;

public class CartTests {

    @Test(description = "LEVEL-2")
    public void shouldClearCart() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://testvagrant.myshopify.com/");
        
        HomePage homePage = new HomePage(driver);
        homePage.addProductsToCart(2);

        new CartPage(driver).clearCart();

        driver.quit();
    }


    @Test(description = "LEVEL-2")
    public void shouldAddItemCart() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://testvagrant.myshopify.com/");

        HomePage homePage = new HomePage(driver);
        homePage.addProductsToCart(2);

        int cartCount = new CartPage(driver).getCartCount();
        Assert.assertEquals(cartCount, 2);

        driver.quit();

    }
//
//    @Test(description = "LEVEL-3")
//    public void shouldIncreaseTotalPriceOnIncreasingQuantity() {
//        WebDriverManager.chromedriver().setup();
//        WebDriver driver = new ChromeDriver();
//
//        driver.get("https://testvagrant.myshopify.com/");
//
//        HomePage homePage = new HomePage(driver);
//        homePage.addProductsToCart(1);
//
//        //ToDo: Remove below line & complete the test
//        Assert.assertEquals(1, 0);
//
//        driver.quit();
//
//    }


}
