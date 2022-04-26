package Test.Pages;

import Test.Base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LeftMenuComponent extends BasePage {
    private By LnkNewCustomer = By.xpath("//a[normalize-space()='New Customer']");
    private By LnkEditCustomer = By.xpath("//a[normalize-space()='Edit Customer']");
    private By LnkDeleteCustomer = By.xpath("//a[normalize-space()='Delete Customer']");
    public LeftMenuComponent(WebDriver driver){
        this.driver = driver;
    }

    public void clickLnkNewCustomer(){
        clickButton(LnkNewCustomer);
    }

    public void clickLnkEditCustomer(){
        clickButton(LnkEditCustomer);
    }

    public void clickLnkDeleteCustomer(){
        clickButton(LnkDeleteCustomer);
    }
}
