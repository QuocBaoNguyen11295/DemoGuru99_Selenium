package Test.Pages;

import Test.Base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NewCustomerPage extends BasePage {
    private By txtCustomerName = By.xpath("//input[@name='name']");
    private By lblCustomerName = By.xpath("//label[@id='message']");
    private By txtAddress = By.xpath("//textarea[@name='addr']");
    private By lblAddress = By.xpath("//label[@id='message3']");
    private By txtCity = By.xpath("//input[@name='city']");
    private By lblCity = By.xpath("//label[@id='message4']");
    private By txtState = By.xpath("//input[@name='state']");
    private By lblState = By.xpath("//label[@id='message5']");
    private By txtPIN = By.xpath("//input[@name='pinno']");
    private By lblPIN = By.xpath("//label[@id='message6']");
    private By txtTelephone = By.xpath("//input[@name='telephoneno']");
    private By lblTelephone = By.xpath("//label[@id='message7']");
    private By txtEmail = By.xpath("//input[@name='emailid']");
    private By lblEmail = By.xpath("//label[@id='message9']");
    private By txtDoB = By.xpath("//input[@name ='dob']");
    private By txtPassword = By.xpath("//input[@name='password']");
    private By btnSub = By.xpath("//input[@name='sub']");
    public NewCustomerPage(WebDriver driver){
        this.driver = driver;
    }

    public void inputCustomerName(String name){
        inputTextField(txtCustomerName,name);
    }

    public void shouldShowTheMessageForNewCustomerAs(String expectedResult){
        String actualResult = this.driver.findElement(lblCustomerName).getText();
        compareBetween(expectedResult,actualResult);
    }

    public void pressTABFromCustomerName(){
        pressTABFromField(txtCustomerName);
    }

    public void inputAddress(String address){
        inputTextField(txtAddress,address);
    }

    public void shouldShowTheMessageForAddressAs(String expectedResult){
        String actualResult = this.driver.findElement(lblAddress).getText();
        compareBetween(expectedResult,actualResult);
    }

    public void pressTABFromAddress(){
        pressTABFromField(txtAddress);
    }

    public void inputCity(String city){
        inputTextField(txtCity,city);
    }

    public void shouldShowTheMessageForCityAs(String expectedResult){
        String actualResult = driver.findElement(lblCity).getText();
        compareBetween(expectedResult,actualResult);
    }

    public void pressTABFromCity(){
        pressTABFromField(txtCity);
    }

    public void inputState(String state){
        inputTextField(txtState,state);
    }

    public void shouldShowTheMessageForStateAs(String expectedResult){
        String actualResult = driver.findElement(lblState).getText();
        compareBetween(expectedResult,actualResult);
    }

    public void pressTABFromState(){ pressTABFromField(txtState); }

    public void inputPIN(String PIN){
        inputTextField(txtPIN,PIN);
    }

    public void pressTABFromPIN() { pressTABFromField(txtPIN); }

    public void shouldShowTheMessageForPINAs(String expectedResult){
        String actualResult = driver.findElement(lblPIN).getText();
        compareBetween(expectedResult,actualResult);
    }

    public void inputTelephone(String telephone){
        inputTextField(txtTelephone,telephone);
    }

    public void pressTABFromTelephone(){
        pressTABFromField(txtTelephone);
    }

    public void shouldShowTheMessageForTelephoneAs(String expectedResult){
        String actualResult = driver.findElement(lblTelephone).getText();
        compareBetween(expectedResult,actualResult);
    }

    public void inputEmail(String email){
        inputTextField(txtEmail,email);
    }

    public void pressTABFromEmail(){
        pressTABFromField(txtEmail);
    }

    public void shouldShowTheMessageForEmailAs(String expectedResult){
        String actualResult = driver.findElement(lblEmail).getText();
        compareBetween(expectedResult,actualResult);
    }
    public void inputDoB(String DoB){
        inputTextField(txtDoB,DoB);
    }

    public void inputPassword(String password){
        inputTextField(txtPassword,password);
    }
    public void clickSubmit(){
        clickButton(btnSub);
    }
    public void createANewCustomer(String Name,String DateOfBirth,String Address,String City,String State,String PIN,String Mobile,String Email,String Password){
        inputCustomerName(Name);
        inputDoB(DateOfBirth);
        inputAddress(Address);
        inputCity(City);
        inputState(State);
        inputPIN(PIN);
        inputTelephone(Mobile);
        inputEmail(Email);
        inputPassword(Password);
    }


}
