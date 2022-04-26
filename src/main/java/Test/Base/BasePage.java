package Test.Base;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public abstract class BasePage {
    protected static WebDriver driver;
    protected void inputTextField(By textField, String value){
        WebElement txtField = driver.findElement(textField);
        txtField.clear();
        txtField.sendKeys(value);
    }

    protected void clickButton(By button){
        WebDriverWait wait = new WebDriverWait(this.driver, Duration.ofSeconds(10));
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(button));
        element.click();
    }

    protected void compareBetween(String expectedResult,String actualResult){
        if(expectedResult.equals(actualResult))
            Assert.assertTrue(true);
        else Assert.assertTrue(false);
    }

    protected void pressTABFromField(By field){
        WebElement webElement = driver.findElement(field);
        webElement.sendKeys(Keys.TAB);
    }

    public static WebDriver getDriver(){
        return driver;
    }

}
