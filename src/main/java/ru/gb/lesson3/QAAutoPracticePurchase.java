package ru.gb.lesson3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class QAAutoPracticePurchase {

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();
        driver.get("http://automationpractice.com/index.php");

        driver.findElement(By.className("login")).click();

        WebDriverWait webDriverWait=new WebDriverWait(driver, Duration.ofSeconds(3));
        //wait for the next pade to load to LOGIN
        webDriverWait.until(ExpectedConditions.urlToBe("http://automationpractice.com/index.php?controller=authentication&back=my-account"));

        driver.findElement(By.xpath("//input[@id='email']")).sendKeys("mailru+1@mail.ru");
        driver.findElement(By.xpath("//input[@data-validate='isPasswd']")).sendKeys("12345678");
        driver.findElement(By.xpath("//button[@id='SubmitLogin']")).click();

        //wait for the new page to load
        webDriverWait.until(ExpectedConditions.urlToBe("http://automationpractice.com/index.php?controller=my-account"));
        //webDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//ul[contains(@class, 'submenu-container' )][2]//a[@title='T-shirts']")));

        //webDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(),'T-shirts')][2]")));
        //webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),'T-shirts')][2]")));
        //driver.findElement(By.xpath("//a[contains(text(),'T-shirts')][2]")).click();
        //driver.findElement(By.xpath("//li[@class='sfHoverForce']")).click();

        //Type in "shirt" in search bar
        driver.findElement(By.xpath("//input[@id='search_query_top']")).sendKeys("shirt");
        driver.findElement(By.xpath("//button[@name='submit_search']")).click();


        //wait for the new page to load
        webDriverWait.until(ExpectedConditions.urlToBe("http://automationpractice.com/index.php?controller=search&orderby=position&orderway=desc&search_query=shirt&submit_search="));




        //webDriverWait.until(ExpectedConditions.urlToBe("http://automationpractice.com/index.php?id_category=5&controller=category"));
        //Chose a shirt
        driver.findElement(By.xpath("//img[@title='Faded Short Sleeve T-shirts']")).click();

        webDriverWait.until(ExpectedConditions.urlToBe("http://automationpractice.com/index.php?id_product=1&controller=product&search_query=shirt&results=1"));

        driver.findElement(By.className("icon-plus")).click();

        Select size = new Select(driver.findElement(By.xpath("//select[@id='group_1']")));
        size.selectByValue("2");
        driver.findElement(By.xpath("//button[@class='exclusive']")).click();

        //Checkout
        webDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@title='Proceed to checkout']")));
        driver.findElement(By.xpath("//a[@title='Proceed to checkout']")).click();

        driver.findElement(By.xpath("//p[@class='cart_navigation clearfix']//a[1]")).click();
        driver.findElement(By.xpath("//button[@name='processAddress']")).click();
        driver.findElement(By.xpath("//input[@id='cgv']")).click();

        driver.findElement(By.xpath("//button[@name='processCarrier']")).click();

        //Pay with check
        driver.findElement(By.xpath("//a[@class='cheque']")).click();
        //Confirm order
        driver.findElement(By.xpath("//button[@class='button btn btn-default button-medium']")).click();



        driver.quit();
    }
}
