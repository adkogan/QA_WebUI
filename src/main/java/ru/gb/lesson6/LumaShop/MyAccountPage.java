package ru.gb.lesson6.LumaShop;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;



public class MyAccountPage extends BaseView {
    public NavigationMenuBlock navigationMenuBlock;

    public MyAccountPage(WebDriver driver) {
        super(driver);
        navigationMenuBlock = new NavigationMenuBlock(driver);
    }






}
