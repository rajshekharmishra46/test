package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class HomePage {

    WebDriver driver;
    Actions actions;
    

    @FindBy(how = How.XPATH, using = "//h2[text()='Our mission']/parent::div//p")
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
        Actions actions = new Actions(driver);
        this.actions=actions;
    }

    public String getOurMissionText() {
        return ourMissionText.getText().trim();
    }

    public void search(String text) {
        searchButton.click();
        searchTextBox.sendKeys(text);
    }
    ////li[@class='grid__item'] //span[text()='Sold out']
    public void addProductsToCart(int productsCount) throws InterruptedException {
        
        int j=1;
        for (int i = 0; i < productsCount; i++) {
        	
        	
        	List<WebElement> elementSoldOut=driver.findElements(By.xpath("(//li[@class='grid__item'])["+j+"]//span[text()='Sold out']"));
        	
        	if(elementSoldOut.size()==0) {
            
            openLinkInNewTab(driver.findElement(By.xpath("(//li[@class='grid__item'])["+j+"]")));
            
        	}
        	else i--;
        	j++;

        }
        int k=0;
        
        for(String window:driver.getWindowHandles())
        {
        	
        	if(k>0)
        	{
        	driver.switchTo().window(window);
            new ProductPage(driver).addToCart();
        	}
        	k++;
        	Thread.sleep(5000);
        }
    }
    
    public void openLinkInNewTab(WebElement ele) {
    	actions.keyDown(Keys.LEFT_CONTROL)
        .click(ele)
        .keyUp(Keys.LEFT_CONTROL)
        .build()
        .perform();
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
