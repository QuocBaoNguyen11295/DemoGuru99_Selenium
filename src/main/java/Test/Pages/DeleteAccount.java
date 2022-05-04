package Test.Pages;

import Test.Base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DeleteAccount extends BasePage {
    private By txtAccountID = By.xpath("//input[@name='accountno']");
    private By lblAccountID = By.xpath("//label[@id='message2']");
    public DeleteAccount(WebDriver driver){
        BasePage.driver = driver;
    }

    public void inputAccountID(String value){
        inputTextField(txtAccountID,value);
    }

    public void shouldShowTheMessageForAccountIDAs(String expectedResult){
        String actualResult = BasePage.driver.findElement(lblAccountID).getText();
        compareBetween(expectedResult,actualResult);
    }

    public void pressTABFromAccountID(){
        pressTABFromField(txtAccountID);
    }

}
