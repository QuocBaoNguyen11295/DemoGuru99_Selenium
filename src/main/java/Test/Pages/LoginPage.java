package Test.Pages;

import Test.Base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage {
    private By txtUsername = By.xpath("//input[@name='uid']");
    private By txtPassword = By.xpath("//input[@name='password']");
    private By btnLogin = By.xpath("//input[@name='btnLogin']");
    private static final String _username = "mgr123";
    private static final String _password = "mgr!23";
    public LoginPage(WebDriver driver){
        this.driver = driver;
    }

    public void inputUsername(){
        inputTextField(txtUsername,_username);
    }

    public void inputPassword(){
        inputTextField(txtPassword,_password);
    }

    public void clickLoginButton(){
        clickButton(btnLogin);
    }

    public void loginToGuru99(){
        inputUsername();
        inputPassword();
        clickLoginButton();
    }
}
