package ru.gb.lesson6.LumaShopTest;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.gb.lesson6.LumaShop.LoginPage;
import ru.gb.lesson6.LumaShop.MainPage;
import ru.gb.lesson6.LumaShop.MyAccountPage;


public class BuyTopTest {
    WebDriver driver;
    MainPage mainPage;
   // MyAccountPage myAccountPage;


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
    void buyTopPositTest() throws InterruptedException {
        mainPage.clickSignInButton()
                .login("adkogan@gmail.com", "12345678ZXc")
                .navigationMenuBlock
                .hoverWomenMenuAndClickTops()
                .selectSize("M")
                .selectColor("Blue")
                .AddToCartByName("Nona")
                .checkCartQuantity("1");


    }


      @AfterEach
      void teardown(){
        driver.quit();
   }
}
