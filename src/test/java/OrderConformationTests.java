import constants.CreditCards;
import entities.CreditCard;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.HomePage;

public class OrderConformationTests {

    @Test(description = "LEVEL-3")
    public void shouldAssertThePaymentDetailsInOrderConfirmationPage() {

        CreditCard visaCard = CreditCards.VISA_CARD;

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://testvagrant.myshopify.com/");

        new CartPage(driver).clearCart();

        HomePage homePage = new HomePage(driver);
        homePage.addProductsToCart(2);

        driver.quit();
    }

}
