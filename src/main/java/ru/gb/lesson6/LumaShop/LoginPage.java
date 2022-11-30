package ru.gb.lesson6.LumaShop;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.gb.lesson6.LumaShop.BaseView;

public class LoginPage extends BaseView {
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//input[@id='email']")
    private WebElement emailField;


    @FindBy(xpath = "//input[@title='Password']")
    private WebElement passwordField;

    @FindBy(xpath = "//button[@class = 'action login primary']")
    private WebElement submitLoginButton;

    @Step("Login")
    public MyAccountPage login(String login, String password){
        emailField.sendKeys(login);
        passwordField.sendKeys(password);
        submitLoginButton.click();

        return new MyAccountPage(driver);
    }




}
