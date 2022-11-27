package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class CartPage {

    @FindBy(how = How.CSS, using = ".icon-remove")
    WebElement deleteButton;


    public CartPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void clearCart() {
        deleteButton.click();
    }

    public int getCartCount() {
        return 0;
    }
}
