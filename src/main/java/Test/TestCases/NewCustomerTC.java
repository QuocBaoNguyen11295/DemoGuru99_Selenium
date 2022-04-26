package Test.TestCases;

import Test.Listeners.ReportListener;
import Test.Listeners.TestNGListener;
import Test.Pages.LeftMenuComponent;
import Test.Pages.LoginPage;
import Test.Pages.ManagerPage;
import Test.Pages.NewCustomerPage;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(ReportListener.class)
public class NewCustomerTC extends TestNGListener {
    LoginPage login;
    NewCustomerPage newCustomer;
    ManagerPage manager;
    LeftMenuComponent leftMenuComponent;
    @Test(description = "Customer id cannot be empty")
    public void tc01(){
        login = new LoginPage(driver);
        login.loginToGuru99();
        manager = new ManagerPage(driver);
        leftMenuComponent = new LeftMenuComponent(driver);
        leftMenuComponent.clickLnkNewCustomer();
        newCustomer = new NewCustomerPage(driver);
        newCustomer.inputCustomerName("");
        newCustomer.pressTABFromCustomerName();
        newCustomer.shouldShowTheMessageForNewCustomerAs("Customer name must not be blank");
    }
    @DataProvider(name = "Data-provider-customer-name")
    public Object[][] dpCustomerName(){
        return new Object[][] {
                {"1234","Numbers are not allowed"},
                {"name123","Numbers are not allowed"},
                {"name!@#","Special characters are not allowed"},
                {"!@#","Special characters are not allowed"},
                {" ","First character can not have space"}
        };
    }
    @Test(dataProvider = "Data-provider-customer-name", description = "Customer name validation test cases")
    public void tc02_tc03_tc04(String value,String expectedResult){
        newCustomer.inputCustomerName(value);
        newCustomer.pressTABFromCustomerName();
        newCustomer.shouldShowTheMessageForNewCustomerAs(expectedResult);
    }

    @DataProvider(name = "Data-provider-address")
    public Object[][] dpAddress(){
        return new Object[][]{
                {"","Address Field must not be blank"},
                {" ","First character can not have space"}
        };
    }

    @Test(dataProvider = "Data-provider-address", description = "Address validation test cases")
    public void tc05_tc06(String value,String expectedResult){
        newCustomer.inputAddress(value);
        newCustomer.pressTABFromAddress();
        newCustomer.shouldShowTheMessageForAddressAs(expectedResult);
    }

    @DataProvider(name = "Data-provider-city")
    public Object[][] dpCity(){
        return new Object[][]{
                {"","City Field must not be blank"},
                {"1234","Numbers are not allowed"},
                {"city123","Numbers are not allowed"},
                {"City!@#","Special characters are not allowed"},
                {"!@#","Special characters are not allowed"},
                {" ","First character can not have space"}
        };
    }

    @Test(dataProvider = "Data-provider-city", description = "City validation test cases")
    public void tc08_tc09_tc10_tc11(String value,String expectedResult){
        newCustomer.inputCity(value);
        newCustomer.pressTABFromCity();
        newCustomer.shouldShowTheMessageForCityAs(expectedResult);
    }

    @DataProvider(name = "Data-provider-state")
    public Object[][] dpState(){
        return new Object[][]{
                {"","State must not be blank"},
                {"1234","Numbers are not allowed"},
                {"State123","Numbers are not allowed"},
                {"State!@#","Special characters are not allowed"},
                {"!@#","Special characters are not allowed"},
                {" ","First character can not have space"}
        };
    }

    @Test(dataProvider = "Data-provider-state",description = "State validation test cases")
    public void tc11_tc12_tc13_tc14(String value,String expectedResult){
        newCustomer.inputState(value);
        newCustomer.pressTABFromState();
        newCustomer.shouldShowTheMessageForStateAs(expectedResult);
    }

    @DataProvider(name = "Data-provider-PIN")
    public Object[][] dpPIN(){
         return new Object[][]{
                 {" 1234","Characters are not allowed"},
                 {"1234PIN","Characters are not allowed"},
                 {"","PIN Code must not be blank"},
                 {"12","PIN Code must have 6 Digits"},
                 {"123","PIN Code must have 6 Digits"},
                 {"!@#","Special characters are not allowed"},
                 {"123!@#","Special characters are not allowed"},
                 {" ","First character can not have space"},
                 {"123 57","Characters are not allowed"}
         };
    }

    @Test(dataProvider = "Data-provider-PIN",description = "PIN validation test cases")
    public void tc16_tc17_tc18_tc19_tc20(String value,String expectedResult){
        newCustomer.inputPIN(value);
        newCustomer.pressTABFromPIN();
        newCustomer.shouldShowTheMessageForPINAs(expectedResult);
    }

    @DataProvider(name = "Data-provider-telephone")
    public Object[][] dpTelephone(){
        return new Object[][]{
                {" ","First character can not have space"},
                {"123 123","Characters are not allowed"},
                {"886636!@12","Special characters are not allowed"},
                {"!@88662682","Special characters are not allowed"},
                {"88663682!@","Special characters are not allowed"}
        };
    }

    @Test(dataProvider = "Data-provider-telephone", description = "Telephone validation test cases")
    public void tc22_tc23_tc24_tc25(String telephone,String expectedResult){
        newCustomer.inputTelephone(telephone);
        newCustomer.pressTABFromTelephone();
        newCustomer.shouldShowTheMessageForTelephoneAs(expectedResult);
    }
    @DataProvider(name = "Data-provider-email")
    public Object[][] dpEmail(){
        return new Object[][]{
                {"","Email-ID must not be blank"},
                {"guru99@gmail ","Email-ID is not valid"},
                {"guru99","Email-ID is not valid"},
                {"guru99@","Email-ID is not valid"},
                {"guru99@gmail.","Email-ID is not valid"},
                {"guru99gmail.com","Email-ID is not valid"}
        };
    }

    @Test(dataProvider = "Data-provider-email", description = "E-mail validation test cases")
    public void tc26_tc27_tc29(String email,String expectedResult){
        newCustomer.inputEmail(email);
        newCustomer.pressTABFromEmail();
        newCustomer.shouldShowTheMessageForEmailAs(expectedResult);
    }
}
