package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class ProductPage {

    @FindBy(how = How.NAME, using = "add")
    WebElement addToCartButton;

    public ProductPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void addToCart() {
        addToCartButton.click();
    }


}
