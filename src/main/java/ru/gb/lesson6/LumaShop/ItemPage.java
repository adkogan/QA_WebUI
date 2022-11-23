package ru.gb.lesson6.LumaShop;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ItemPage extends BaseView{
    public ItemPage(WebDriver driver) {
        super(driver);
    }

    private static final String addToCartButtonXpathLocator = "//button[@title='Add to Cart']";
    @FindBy(xpath = addToCartButtonXpathLocator)
    private WebElement addToCartButton;


//    public void addToCart();



}
