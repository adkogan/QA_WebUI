package ru.gb.lesson6.LumaShop;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class NavigationMenuBlock extends BaseView {
    public NavigationMenuBlock(WebDriver driver) {
        super(driver);
    }


    @FindBy(xpath = "//span[contains(., 'Women')]")
    private WebElement womenButton;




    @FindBy(xpath = "//a[@id='ui-id-9']")
    private WebElement topsMenu;

    @Step("Hover mouse on Women Menu")
    public TopsPage hoverWomenMenuAndClickTops(){
        webDriverWait.until(ExpectedConditions.visibilityOf(womenButton));
        actions.moveToElement(womenButton)
                .perform();
        webDriverWait.until(ExpectedConditions.elementToBeClickable(topsMenu));
        topsMenu.click();

        return new TopsPage(driver);

    }



}

