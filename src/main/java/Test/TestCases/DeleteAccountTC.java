package Test.TestCases;

import Test.Listeners.TestNGListener;
import Test.Pages.DeleteAccount;
import Test.Pages.LeftMenuComponent;
import Test.Pages.LoginPage;
import Test.Pages.ManagerPage;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DeleteAccountTC extends TestNGListener {
    LoginPage loginPage;
    ManagerPage managerPage;
    LeftMenuComponent leftMenuComponent;
    DeleteAccount deleteAccount;
    @BeforeTest
    public void precondition_test(){
        loginPage = new LoginPage(driver);
        loginPage.loginToGuru99();
        managerPage = new ManagerPage(driver);
        leftMenuComponent = new LeftMenuComponent(driver);
        leftMenuComponent.clickLnkDeleteAccount();
        deleteAccount = new DeleteAccount(driver);
    }

    @DataProvider(name = "Data-provider-account-id")
    public Object[][] dpAccountID(){
        return new Object[][]{
                {"","Account Number must not be blank"},
                {"1234","Characters are not allowed"},
                {"Acc123","Characters are not allowed"},
                {"123!@#","Special characters are not allowed"},
                {"!@#","Special characters are not allowed"},
                {"123 12","Characters are not allowed"},
                {" ","Characters are not allowed"}
        };
    }

    @Test(dataProvider = "Data-provider-account-id",priority = 1)
    public void da01_da02_da03_da04_da05(String value,String expectedResult){
        deleteAccount.inputAccountID(value);
        deleteAccount.pressTABFromAccountID();
        deleteAccount.shouldShowTheMessageForAccountIDAs(expectedResult);
    }
}
