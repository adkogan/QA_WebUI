package ru.gb.lesson6.LumaShopTest;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Allure;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.RegisterExtension;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.support.events.EventFiringDecorator;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import ru.gb.lesson6.LumaShop.*;


import java.io.ByteArrayInputStream;

import static org.openqa.selenium.OutputType.BYTES;


@Story("Add item to cart")
public class BuyTopTest {
    WebDriver driver;


    @RegisterExtension
    TestExtention watcher = new TestExtention();


    @BeforeAll
    static void registerDriver(){

        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void initDriver(){
        driver = new EventFiringDecorator(new AdditionalLogger()).decorate(new ChromeDriver());

        //mainPage= new MainPage(driver);
        driver.get("https://magento.softwaretestingboard.com/");

    }


    @Test
    @Feature("Cart")
    @DisplayName("Add top to cart")
    void buyTopPositTest() throws InterruptedException {
       new MainPage(driver).clickSignInButton()
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
          watcher.setScreenStream(new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(BYTES)));

          LogEntries logEntries = driver.manage().logs().get(LogType.BROWSER);

          for (LogEntry log: logEntries) {
              Allure.addAttachment("Элемент лога браузера", log.getMessage());
          }



          driver.quit();
   }
}
