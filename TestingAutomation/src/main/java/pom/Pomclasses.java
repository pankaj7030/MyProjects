package pom;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Pomclasses {
public WebDriver driver;
	// Initialization
	@FindBy(xpath = "//a[text()='Tabs']")
	private WebElement tab;
	@FindBy(xpath = "////div[@id='accordion']/h3[1]")
	private WebElement select;
	@FindBy(xpath = "//div[@id=\"ui-id-2\"]/p")
	private WebElement text;
	@FindBy(xpath = "")
	private WebElement d;
	@FindBy(xpath = "")
	private WebElement e;
	@FindBy(xpath = "")
	private WebElement f;

	// declaration
	public Pomclasses(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
		
    //usage
	public void clickTab() {
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true)",tab);
			tab.click();
	}
	public void clickOnSection() {
		select.click();
	}
	public void getText() {
		text.getText();
		
		
	}

}
