package Test.Pages;

import Test.Base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class EditCustomerPageForCustomerID extends BasePage {
    private By TxtCustomerID = By.xpath("//input[@name='cusid']");
    private By btnSubmit = By.xpath("//input[@name='AccSubmit']");
    private By lblCustomerID = By.xpath("//label[@id='message14']");
    public EditCustomerPageForCustomerID(WebDriver driver){
        this.driver = driver;
    }

    public void inputCustomerID(String customerID){
        inputTextField(TxtCustomerID,customerID);
    }
    public void pressTABFromCustomerID(){
        pressTABFromField(TxtCustomerID);
    }

    public void shouldShowTheMessageForCustomerIDAs(String expectedResult){
        String actualResult = driver.findElement(lblCustomerID).getText();
        compareBetween(expectedResult,actualResult);
    }
    public void clickToEditCustomer(){
        clickButton(btnSubmit);
    }
}
