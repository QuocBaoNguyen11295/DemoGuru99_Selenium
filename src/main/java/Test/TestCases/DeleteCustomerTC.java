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
public class DeleteCustomerTC extends TestNGListener {
    LoginPage login;
    ManagerPage manager;
    LeftMenuComponent leftMenuComponent;
    NewCustomerPage newCustomer;
    CustomerRegisterSuccessfullyPage customerRegisterSuccessfullyPage;

    DeleteCustomer deleteCustomer;
    @BeforeTest
    public void precondition_test(){
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
        String customerID = customerRegisterSuccessfullyPage.getCustomerID();
        System.out.println(customerID);
        customerRegisterSuccessfullyPage.clickContinue();
        leftMenuComponent.clickLnkDeleteCustomer();
        deleteCustomer = new DeleteCustomer(driver);
    }

    @DataProvider(name = "Data-provider-customerID")
    public Object[][] dpCustomerID(){
        return new Object[][]{
                {"","Customer ID is required"},
                {"1234^","Characters are not allowed"},
                {"Acc123","Characters are not allowed"},
                {"123!@#","Special characters are not allowed"},
                {"!@#","Special characters are not allowed"},
                {"123 12","Characters are not allowed"},
                {" ","First Characters can not have space"}
        };
    }

    @Test(dataProvider = "Data-provider-customerID",description = "Validate CustomerID field",priority = 1)
    public void da01_da02_da03_da04_da05(String value,String expectedResult){
        deleteCustomer.inputCustomerID(value);
        deleteCustomer.pressTABFromCustomerID();
        deleteCustomer.shouldShowTheMessageForCustomerIDAs(expectedResult);
    }


}
