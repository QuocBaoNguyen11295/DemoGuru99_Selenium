package Test.Pages;

import Test.Base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LeftMenuComponent extends BasePage {
    private By LnkNewCustomer = By.xpath("//a[normalize-space()='New Customer']");
    private By LnkEditCustomer = By.xpath("//a[normalize-space()='Edit Customer']");
    private By LnkDeleteCustomer = By.xpath("//a[normalize-space()='Delete Customer']");

    private By LnkNewAccount = By.xpath("//a[normalize-space()='New Account']");
    private By LnkDeleteAccount = By.xpath("//a[normalize-space()='Delete Account']");
    private By LnkMiniStatement = By.xpath("//a[@href='MiniStatementInput.php']");
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

    public void clickLnkNewAccount(){ clickButton(LnkNewAccount); }
    public void clickLnkDeleteAccount(){
        clickButton(LnkDeleteAccount);
    }

    public void clickLnkMiniStatement(){
        clickButton(LnkMiniStatement);
    }
}
