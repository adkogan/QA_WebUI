package ru.gb.lesson3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class QAAutoPracticeNewAccount {
    public static void main(String[] args) throws InterruptedException {


        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();
        driver.get("http://automationpractice.com/index.php");

        driver.findElement(By.className("login")).click();

        WebDriverWait webDriverWait=new WebDriverWait(driver, Duration.ofSeconds(3));
        //wait for the next pade to load
        webDriverWait.until(ExpectedConditions.urlToBe("http://automationpractice.com/index.php?controller=authentication&back=my-account"));

        driver.findElement(By.xpath("//input[@id='email_create']")).sendKeys("mailru+1@mail.ru");
        driver.findElement(By.xpath("//button[@id='SubmitCreate']")).click();


        //wait for the next pade to load
       webDriverWait.until(ExpectedConditions.urlToBe("http://automationpractice.com/index.php?controller=authentication&back=my-account#account-creation"));

        driver.findElement(By.xpath("//input[@id='id_gender2']")).click();
        driver.findElement(By.id("customer_firstname")).sendKeys("Maria");
        driver.findElement(By.id("customer_lastname")).sendKeys("Marieva");
        driver.findElement(By.id("passwd")).sendKeys("12345678");

        // Select date of Birth
        Select days = new Select(driver.findElement(By.xpath("//select[@id=\"days\"]")));

        days.selectByValue("11");

        Select months = new Select(driver.findElement(By.xpath("//select[@id=\"months\"]")));
        months.selectByValue("11");

        Select years = new Select(driver.findElement(By.xpath("//select[@id=\"years\"]")));
       // years.selectByValue("2005");
        years.selectByIndex(21);

        //Newsletter checkbox
        driver.findElement(By.id("newsletter")).click();

        //Address
        driver.findElement(By.id("company")).sendKeys("Text");
        driver.findElement(By.xpath("//input[@id='address1']")).sendKeys("Main street, 12345, Text");
        driver.findElement(By.xpath("//input[@id='address2']")).sendKeys("12, 2, 3");
        driver.findElement(By.xpath("//input[@id='city']")).sendKeys("Fresno");

        //Select State
        Select state = new Select(driver.findElement(By.xpath("//select[@id='id_state']")));
        state.selectByValue("5");

        //Input postcode
        driver.findElement(By.xpath("//input[@id='postcode']")).sendKeys("12345");

        //Input mobile
        driver.findElement(By.xpath("//input[@id='phone_mobile']")).sendKeys("12345678");

        driver.findElement(By.xpath("//button[@id='submitAccount']")).click();




        //Thread.sleep(5000);

        driver.quit();








    }

    }


