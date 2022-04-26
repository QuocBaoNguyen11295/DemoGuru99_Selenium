package Test.Pages;

import Test.Base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CustomerRegisterSuccessfullyPage extends BasePage {
    private By customerIDValue = By.xpath("//table[@id='customer']/tbody/tr[4]/td[2]");
    private By btnContinue = By.xpath("//a[normalize-space()='Continue']");
    public CustomerRegisterSuccessfullyPage(WebDriver driver){
        this.driver = driver;
    }

    public String getCustomerID(){
        return this.driver.findElement(customerIDValue).getText();
    }

    public ManagerPage clickContinue(){
        clickButton(btnContinue);
        return new ManagerPage(driver);
    }




}
