import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;

public class HomePageTests {

    @Test(description = "LEVEL-1")
    public void shouldVerifyTitle() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://testvagrant.myshopify.com/");
        String t = driver.getTitle();

        driver.quit();

        Assert.assertEquals(t, "myshopify.com");

    }

    @Test(description = "LEVEL-1")
    public void shouldAssertTheVisionOfTheCompany() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://testvagrant.myshopify.com/");

        HomePage homePage = new HomePage(driver);
        String missionText = homePage.getOurMissionText();

        driver.quit();

        Assert.assertEquals(missionText, "Shopping should be fun, convenient and affordable");

    }
}
