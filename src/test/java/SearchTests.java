import io.github.bonigarcia.wdm.WebDriverManager;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;

public class SearchTests {

    @SuppressWarnings("deprecation")
	@Test(description = "LEVEL-1")
    public void shouldVerifySearchResults() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(5000));
        driver.get("https://testvagrant.myshopify.com/");

        HomePage homePage = new HomePage(driver);
        homePage.search("adidas");
        
        //ToDo: Remove below line & Please add assertion logic. Assert that every search result contains search text.
        //Assert.assertEquals(1, 0);
        
        for (String item:homePage.getTextFromSearchResult()) {
        	//System.out.println(item);
        	Assert.assertTrue(item.toLowerCase().contains("adidas"));
        }

        driver.quit();
    }

}
