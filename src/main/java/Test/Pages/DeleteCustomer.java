package Test.Pages;

import Test.Base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DeleteCustomer extends BasePage {
    private final By txtCustomerID = By.xpath("//input[@name='cusid']");
    private final By lblCustomerID = By.xpath("//label[@id='message14']");
    private final By btnSubmit = By.xpath("//input[@name='AccSubmit']");
    public DeleteCustomer(WebDriver driver){
        BasePage.driver = driver;
    }

    public void inputCustomerID(String value){
        inputTextField(txtCustomerID,value);
    }

    public void shouldShowTheMessageForCustomerIDAs(String expectedResult){
        String actualResult = driver.findElement(lblCustomerID).getText();
        compareBetween(expectedResult,actualResult);
    }

    public void pressTABFromCustomerID(){
        pressTABFromField(txtCustomerID);
    }


}
