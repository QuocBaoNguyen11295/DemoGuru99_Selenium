package Test.TestCases;

import Test.Listeners.TestNGListener;
import Test.Pages.LeftMenuComponent;
import Test.Pages.LoginPage;
import Test.Pages.MiniStatement;
import org.testng.annotations.*;

import java.time.Duration;

public class MiniStatementTC extends TestNGListener {
    LoginPage loginPage;
    LeftMenuComponent leftMenuComponent;
    MiniStatement miniStatement;
    @BeforeTest
    public void precondition_test(){
        super.beforeTest();
        loginPage = new LoginPage(driver);
        loginPage.loginToGuru99();
        leftMenuComponent = new LeftMenuComponent(driver);
        leftMenuComponent.clickLnkMiniStatement();
        miniStatement = new MiniStatement(driver);
    }
    @AfterTest
    public void afterTest() {
        closeBrowser();
    }
    @DataProvider(name = "Data-provider-mini-statement")
    public Object[][] dpMiniStatement(){
        return new Object[][] {
                {"","Account Number must not be blank"},
                {"1234","Characters are not allowed"},
                {"Acc123","Characters are not allowed"},
                {"123!@#","Special characters are not allowed"},
                {"!@#","Special characters are not allowed"},
                {"123 12","Characters are not allowed"},
                {" ","Characters are not allowed"}
        };
    }

    @Test(dataProvider = "Data-provider-mini-statement")
    public void ms01_ms02_ms03_ms04_ms05(String value,String expectedResult){
        miniStatement.inputTxtAccountNo(value);
        miniStatement.pressTABFromTxtAccountNo();
        miniStatement.shouldShowTheMessageForAccountNo(expectedResult);
    }


}
