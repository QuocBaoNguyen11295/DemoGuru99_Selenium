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
public class NewAccountTC extends TestNGListener {
    LoginPage loginPage;
    ManagerPage managerPage;
    LeftMenuComponent leftMenuComponent;
    NewAccountPage newAccountPage;
    @BeforeTest
    public void precondition(){
        loginPage = new LoginPage(driver);
        loginPage.loginToGuru99();
        managerPage = new ManagerPage(driver);
        leftMenuComponent = new LeftMenuComponent(driver);
        leftMenuComponent.clickLnkNewAccount();
        newAccountPage = new NewAccountPage(driver);
    }

    @DataProvider(name = "Data-provider-customer-id")
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

    @Test(dataProvider = "Data-provider-customer-id",description = "Validate customer id field",priority = 1)
    public void na01_na02_na03_na04_na05(String value,String expectedResult){
        newAccountPage.inputCustomerID(value);
        newAccountPage.pressTABFromCustomerID();
        newAccountPage.shouldShowTheMessageForCustomerID(expectedResult);
    }

    @DataProvider(name = "Data-provider-initial-deposit")
    public Object[][] dpInitialDeposit(){
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

    @Test(dataProvider = "Data-provider-initial-deposit",description = "Validate initial deposit field",priority = 2)
    public void na06_na07_na08_na09_na10(String value,String expectedResult){
        newAccountPage.inputInitialDeposit(value);
        newAccountPage.pressTABFromInitialDeposit();
        newAccountPage.shouldShowTheMessageForInitialDeposit(expectedResult);
    }
}
