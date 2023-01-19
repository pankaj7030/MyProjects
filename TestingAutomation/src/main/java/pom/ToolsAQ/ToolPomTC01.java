package pom.ToolsAQ;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ToolPomTC01 {

	//initialization
	@FindBy(xpath="")private WebElement b;
	
	
	//Declaration
	public ToolPomTC01(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	
	//Usage
	public void title() {
		
	}
}
