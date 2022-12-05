package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class HomePage {

    WebDriver driver;

    @FindBy(how = How.CSS, using = ".footer-block.grid__item")
    private WebElement ourMissionText;

    @FindBy(how = How.CSS, using = ".icon-search")
    public WebElement searchButton;

    @FindBy(how = How.CSS, using = ".icon-cart")
    public WebElement cartButton;

    @FindBy(how = How.ID, using = "Search-In-Modal")
    public WebElement searchTextBox;


    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getOurMissionText() {
        return ourMissionText.getText().trim();
    }

    public void search(String text) {
        searchButton.click();
        searchTextBox.sendKeys(text);
    }

    public void addProductsToCart(int productsCount) {
        List<WebElement> elements = driver.findElements(By.cssSelector(".product-grid .grid__item"));

        for (int i = 0; i < productsCount; i++) {

            elements.get(i).click();
            new ProductPage(driver).addToCart();

        }
    }
    @FindBy(how = How.XPATH, using = "//ul[@id='predictive-search-results-list']/li//h3")
    public List<WebElement> searchResult;
    
    public List<String> getTextFromSearchResult() throws InterruptedException {
    	List<String> searchResultItems = new ArrayList<String>();
    	int i =0;
    	
    	
    	while(i<searchResult.size()) {
    		
    		searchResultItems.add(searchResult.get(i).getText());
    		i++;
    }
    	return searchResultItems;
}
}
