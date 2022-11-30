package ru.gb.lesson6.LumaShop;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class MainPage extends BaseView {


    public MainPage(WebDriver driver) {
        super(driver);
    }

       // @FindBy(xpath = "//a[contains(.,'Sign In')]")
        @FindBy(xpath = "//div[@class='panel header']/ul/li[2]/a")
        private WebElement signInButton;

        @Step("Click on login link")
        public LoginPage clickSignInButton () {
            signInButton.click();
            return new LoginPage(driver);
        }

    private static final String loginSuccessMessageXpathLocator = "//span[@class='logged-in']";
    @FindBy(xpath = loginSuccessMessageXpathLocator)
    private WebElement loginSuccessMessage;



    public boolean registerSuccessMessageIsDisplayed() {
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(loginSuccessMessageXpathLocator)));
        return loginSuccessMessage.isDisplayed();
    }

    }

