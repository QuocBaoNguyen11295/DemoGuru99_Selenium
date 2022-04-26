package Test.Pages;

import Test.Base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class EditCustomer extends BasePage {
    private final By txtAddress = By.xpath("//textarea[@name='addr']");
    private final By lblAddress = By.xpath("//label[@id='message3']");
    private final By txtCity = By.xpath("//input[@name='city']");
    private final By lblCity = By.xpath("//label[@id='message4']");
    private final By txtState = By.xpath("//input[@name='state']");
    private final By lblState = By.xpath("//label[@id='message5']");
    private final By txtPinno = By.xpath("//input[@name='pinno']");
    private final By lblPinno = By.xpath("//label[@id='message6']");
    private final By txtTelephone = By.xpath("//input[@name='telephoneno']");
    private final By lblTelephone = By.xpath("//label[@id='message7']");
    private final By txtEmail = By.xpath("//input[@name='emailid']");
    private final By lblEmail = By.xpath("//label[@id='message9']");
    public EditCustomer(WebDriver driver){
        BasePage.driver = driver;
    }

    public void inputAddress(String value){
        inputTextField(txtAddress,value);
    }

    public void pressTABFromAddress(){
        pressTABFromField(txtAddress);
    }

    public void shouldShowTheMessageForAddressAs(String expectedResult){
        String actualResult = driver.findElement(lblAddress).getText();
        compareBetween(expectedResult,actualResult);
    }
    public void inputCity(String value){
        inputTextField(txtCity,value);
    }
    public void pressTABFromCity(){
        pressTABFromField(txtCity);
    }
    public void shouldShowTheMessageForCityAs(String expectedResult){
        String actualResult = driver.findElement(lblCity).getText();
        compareBetween(expectedResult,actualResult);
    }

    public void inputState(String value){
        inputTextField(txtState,value);
    }

    public void pressTABFromState(){
        pressTABFromField(txtState);
    }

    public void shouldShowTheMessageForStateAs(String expectedResult){
        String actualResult = driver.findElement(lblState).getText();
        compareBetween(expectedResult,actualResult);
    }

    public void inputPinno(String value){
        inputTextField(txtPinno,value);
    }

    public void pressTABFromPin(){
        pressTABFromField(txtPinno);
    }

    public void shouldShowTheMessageForPinAs(String expectedResult){
        String actualResult = driver.findElement(lblPinno).getText();
        compareBetween(expectedResult,actualResult);
    }

    public void inputTelephone(String value){
        inputTextField(txtTelephone,value);
    }

    public void pressTABFromTelephone(){
        pressTABFromField(txtTelephone);
    }

    public void shouldShowTheMessageForTelephoneAs(String expectedResult){
        String actualResult = driver.findElement(lblTelephone).getText();
        compareBetween(expectedResult,actualResult);
    }

    public void inputEmail(String value){
        inputTextField(txtEmail,value);
    }

    public void pressTABFromEmail(){
        pressTABFromField(txtEmail);
    }

    public void shouldShowTheMessageForEmailAs(String expectedResult){
        String actualResult = driver.findElement(lblEmail).getText();
        compareBetween(expectedResult,actualResult);
    }

    public void editSomeInfoCustomer(String address){

    }




}
