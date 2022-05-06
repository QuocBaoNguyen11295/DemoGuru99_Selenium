package Test.Pages;

import Test.Base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MiniStatement extends BasePage {
    private final By txtAccountNo = By.xpath("//input[@name='accountno']");
    private final By lblAccountNo = By.xpath("//label[@id='message2']");
    public MiniStatement(WebDriver driver){
        BasePage.driver = driver;
    }

    public void inputTxtAccountNo(String value){
        super.inputTextField(txtAccountNo,value);
    }

    public void pressTABFromTxtAccountNo(){
        super.pressTABFromField(txtAccountNo);
    }

    public void shouldShowTheMessageForAccountNo(String expectedResult){
        String actualResult = driver.findElement(lblAccountNo).getText();
        compareBetween(expectedResult,actualResult);
    }
}
