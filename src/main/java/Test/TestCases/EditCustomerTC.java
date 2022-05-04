package Test.TestCases;

import Test.Listeners.ReportListener;
import Test.Listeners.TestNGListener;
import Test.Pages.*;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.util.Random;
@Listeners(ReportListener.class)
public class EditCustomerTC extends TestNGListener {
    LoginPage login;
    NewCustomerPage newCustomer;
    ManagerPage manager;
    LeftMenuComponent leftMenuComponent;
    CustomerRegisterSuccessfullyPage customerRegisterSuccessfullyPage;
    EditCustomerPageForCustomerID editCustomerPageForCustomerID;
    EditCustomer editCustomer;
    String customerID;
    @BeforeTest
    public void precondition_steps(){
        login = new LoginPage(driver);
        login.loginToGuru99();
        manager = new ManagerPage(driver);
        leftMenuComponent = new LeftMenuComponent(driver);
        leftMenuComponent.clickLnkNewCustomer();
        newCustomer = new NewCustomerPage(driver);
        Random generator = new Random();
        int value = generator.nextInt(2001) + 1;
        String value_string = Integer.toString(value);
        newCustomer.createANewCustomer("Bao Bao Nguyen","12/01/2002","124 A","HCM","HCM","121221","090090123","b30nguyen"+value_string+"@gmail.com","32313");
        newCustomer.clickSubmit();
        customerRegisterSuccessfullyPage = new CustomerRegisterSuccessfullyPage(driver);
        customerID = customerRegisterSuccessfullyPage.getCustomerID();
        System.out.println(customerID);
        customerRegisterSuccessfullyPage.clickContinue();
        manager = new ManagerPage(driver);
        leftMenuComponent = new LeftMenuComponent(driver);
        leftMenuComponent.clickLnkEditCustomer();
        editCustomerPageForCustomerID = new EditCustomerPageForCustomerID(driver);
    }

    @DataProvider(name = "Data-provider-customer-id")
    public Object[][] dpCustomerID(){
        return new Object[][] {
                {"","Customer ID is required"},
                {"1234Acc","Characters are not allowed"},
                {"Acc123","Characters are not allowed"},
                {"123!@#","Special characters are not allowed"},
                {"!@#","Special characters are not allowed"}
        };
    }

    @Test(dataProvider = "Data-provider-customer-id", description = "validate customer id",priority = 1)
    public void ec01_ec02_ec03_ec04(String value,String expectedResult){
        editCustomerPageForCustomerID.inputCustomerID(value);
        editCustomerPageForCustomerID.pressTABFromCustomerID();
        editCustomerPageForCustomerID.shouldShowTheMessageForCustomerIDAs(expectedResult);
    }


    @Test(description = "validate address field",priority = 2)
    public void ec08(){
        editCustomerPageForCustomerID.inputCustomerID(customerID);
        editCustomerPageForCustomerID.clickToEditCustomer();
        editCustomer = new EditCustomer(driver);
        editCustomer.inputAddress("");
        editCustomer.pressTABFromAddress();
        editCustomer.shouldShowTheMessageForAddressAs("Address Field must not be blank");
    }
    @DataProvider(name = "Data-provider-city")
    public Object[][] dpCity(){
        return new Object[][]{
                {"","City Field must not be blank"},
                {"1234","Numbers are not allowed"},
                {"city123","Numbers are not allowed"},
                {"City!@#","Special characters are not allowed"},
                {"!@#","Special characters are not allowed"}
        };
    }

    @Test(dataProvider = "Data-provider-city",description = "validate city field",priority = 3)
    public void ec10_ec11_ec12(String value,String expectedResult){
        editCustomer.inputCity(value);
        editCustomer.pressTABFromCity();
        editCustomer.shouldShowTheMessageForCityAs(expectedResult);
    }

    @DataProvider(name = "Data-provider-state")
    public Object[][] dpState(){
        return new Object[][]{
                {"","State must not be blank"},
                {"1234","Numbers are not allowed"},
                {"State123","Numbers are not allowed"},
                {"State!@#","Special characters are not allowed"},
                {"!@#","Special characters are not allowed"}
        };
    }

    @Test(dataProvider = "Data-provider-state",description = "validate state field",priority = 4)
    public void ec13_ec14_ec15(String value,String expectedResult){
        editCustomer.inputState(value);
        editCustomer.pressTABFromState();
        editCustomer.shouldShowTheMessageForStateAs(expectedResult);
    }
    @DataProvider(name = "Data-provider-pin")
    public Object[][] dpPIN(){
        return new Object[][]{
                {"1234","Characters are not allowed"},
                {"1234PIN","Characters are not allowed"},
                {"","PIN Code must not be blank"},
                {"1234567","PIN Code must have 6 Digits"},
                {"123","PIN Code must have 6 Digits"},
                {"!@#","Special characters are not allowed"},
                {"123!@#","Special characters are not allowed"}
        };
    }

    @Test(dataProvider = "Data-provider-pin",description = "Validate PIN field",priority = 5)
    public void ec16_ec17_ec18_ec19(String value,String expectedResult){
        editCustomer.inputPinno(value);
        editCustomer.pressTABFromPin();
        editCustomer.shouldShowTheMessageForPinAs(expectedResult);
    }

    @DataProvider(name = "Data-provider-telephone")
    public Object[][] dpTelephone(){
        return new Object[][]{
                {"","Mobile no must not be blank"},
                {"886636!@12","Special characters are not allowed"},
                {"!@88662682","Special characters are not allowed"},
                {"88663682!@","Special characters are not allowed"}
        };
    }

    @Test(dataProvider = "Data-provider-telephone",description = "Validate telephone field",priority = 6)
    public void ec20_ec21(String value,String expectedResult){
        editCustomer.inputTelephone(value);
        editCustomer.pressTABFromTelephone();
        editCustomer.shouldShowTheMessageForTelephoneAs(expectedResult);
    }

    @DataProvider(name = "Data-provider-email")
    public Object[][] dpEmail(){
        return new Object[][]{
                {"","Email-ID must not be blank"},
                {"guru99@gmail","Email-ID is not valid"},
                {"guru99","Email-ID is not valid"},
                {"Guru99@","Email-ID is not valid"},
                {"gurugmail.com","Email-ID is not valid"}
        };
    }

    @Test(dataProvider = "Data-provider-email",description = "Validate email field",priority = 7)
    public void ec22_ec23(String value,String expectedResult){
        editCustomer.inputEmail(value);
        editCustomer.pressTABFromEmail();
        editCustomer.shouldShowTheMessageForEmailAs(expectedResult);
    }
}
