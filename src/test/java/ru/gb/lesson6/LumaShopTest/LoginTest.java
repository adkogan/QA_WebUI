package ru.gb.lesson6.LumaShopTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.gb.lesson6.LumaShop.MainPage;

public class LoginTest {
    WebDriver driver;
    MainPage mainPage;



    @BeforeAll
    static void registerDriver(){

        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void initDriver(){
        driver=new ChromeDriver();
        mainPage= new MainPage(driver);
        driver.get("https://magento.softwaretestingboard.com/");

    }


    @Test
    void LoginPositTest(){
        mainPage.clickSignInButton()
                .login("adkogan@gmail.com", "12345678ZXc");
        Assertions.assertTrue(mainPage.registerSuccessMessageIsDisplayed());
    }






    @AfterEach
    void teardown(){
        driver.quit();
    }

}
