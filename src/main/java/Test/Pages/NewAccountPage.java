package Test.Pages;

import Test.Base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NewAccountPage extends BasePage {
    private final By txtCustomerID = By.xpath("//input[@name='cusid']");
    private final By lblCustomerID = By.xpath("//label[@id='message14']");
    private final By txtInitialDeposit = By.xpath("//input[@name='inideposit']");
    private final By lblInitialDeposit = By.xpath("//label[@id='message19']");
    public NewAccountPage(WebDriver driver){
        BasePage.driver = driver;
    }
    public void inputCustomerID(String value){
        inputTextField(txtCustomerID,value);
    }

    public void pressTABFromCustomerID(){
        pressTABFromField(txtCustomerID);
    }

    public void shouldShowTheMessageForCustomerID(String expectedResult){
        String actualResult = driver.findElement(lblCustomerID).getText();
        compareBetween(expectedResult,actualResult);
    }

    public void inputInitialDeposit(String value){
        inputTextField(txtInitialDeposit,value);
    }

    public void pressTABFromInitialDeposit(){
        pressTABFromField(txtInitialDeposit);
    }

    public void shouldShowTheMessageForInitialDeposit(String expectedResult){
        String actualResult = driver.findElement(lblInitialDeposit).getText();
        compareBetween(expectedResult,actualResult);
    }
}
