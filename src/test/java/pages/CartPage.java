package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class CartPage {
	

    @FindBy(how = How.XPATH, using = "//*[@class='icon icon-remove']")
    List<WebElement> deleteButton;
    @FindBy(how = How.XPATH, using = "//*[@class='icon icon-remove']")
    List<WebElement> deleteButton1;

    @FindBy(how = How.CSS, using = ".icon-cart")
    WebElement cart;

    public CartPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }


    public void clearCart() throws InterruptedException {
    	cart.click();
    	for(WebElement ele:deleteButton)
    	{
    		try {
        ele.click();

    		}
    		catch(Exception e) {
    			for(WebElement ele1:deleteButton1)
    	    	{
    				ele1.click();
    	    	}
    		}
    	}
    }

    public int getCartCount() {
        return 0;
    }
}
