package ru.gb.lesson6.LumaShop;

import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;
import java.util.List;
import java.util.Optional;

public class TopsPage extends BaseView{
    public TopsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div[.='Size']")
    private WebElement sizeMenu;

    @FindBy(xpath = "//div[.='Size']/ancestor::div[@role='presentation']//a/div")
    private List<WebElement> sizeList;

    @Step("Chose size")
    public TopsPage selectSize(String size) throws InterruptedException {


        sizeMenu.click();
        //webDriverWait.until(d -> sizeList.size()>0);
        sizeList
                .stream()
                .filter(s -> s.getText().contains(size))
                .findFirst()
                .get()
                .click();
        return this;
    }

    @FindBy(xpath = "//div[.='Color']")
    private WebElement colorMenu;

    //@FindBy(xpath = "//div[.='Color']/ancestor::div[@role='presentation']//a/div")
    @FindBy(xpath = "//div[@class = 'swatch-attribute swatch-layered color']//a/div")
    private List<WebElement> colorList;

    @Step("Chose color")
    public TopsPage selectColor(String color) throws InterruptedException {

       //webDriverWait.until(ExpectedConditions.urlToBe("https://magento.softwaretestingboard.com/women/tops-women.html?size=168"));
       // Thread.sleep(3000);
       colorMenu.click();
       webDriverWait.until(d -> colorList.size()>0);

        Optional<WebElement> first = colorList
                .stream()
                .filter(
                        c -> c.getAttribute("Option-label").contains(color)
                )
                .findFirst();
        first
                .get()
                .click();
        return this;
    }

    @FindBy(xpath = "//div[@class ='product-item-info']")
    private List<WebElement> topsList;


    private static final String addToCartButtonXpathLocator = "//button[@title='Add to Cart']";
    @FindBy(xpath = addToCartButtonXpathLocator)
    private WebElement addToCartButton;


    @Step("Hover mouse over item")
    public TopsPage AddToCartByName(String topName) {

        String productXPath = String.format(
            "//div[@class ='product-item-info' and descendant::a[contains(text(), 'Nona')]]",
            topName
        );
        String addButtonXpath = productXPath + "//button[@title='Add to Cart']";
        actions.moveToElement(driver.findElement(By.xpath(productXPath)));
        WebElement button = driver.findElement(By.xpath(addButtonXpath));
        actions.moveToElement(button);
        actions.click();
        actions.build().perform();



        return this;


    }


    @FindBy(xpath = "//span[@class='counter-number']")
    private WebElement cartQuantity;

    private final static String successMessageXpathLocator="//div[@class='message-success success message']";

    @Step("Check number of items in the cart")
    public void checkCartQuantity(String expectedCartQuantity){
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(successMessageXpathLocator)));

        Assertions.assertEquals(expectedCartQuantity, cartQuantity.getText());

    }





}
