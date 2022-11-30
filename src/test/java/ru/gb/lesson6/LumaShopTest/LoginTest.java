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
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.support.events.EventFiringDecorator;
import ru.gb.lesson6.LumaShop.AdditionalLogger;
import ru.gb.lesson6.LumaShop.MainPage;
import ru.gb.lesson6.LumaShop.TestExtention;

import java.io.ByteArrayInputStream;
import static org.openqa.selenium.OutputType.BYTES;

@Story("Successful login test")
public class LoginTest {
    WebDriver driver;
    MainPage mainPage;


    @RegisterExtension
    TestExtention watcher = new TestExtention();



    @BeforeAll
    static void registerDriver(){

        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void initDriver(){
        driver = new EventFiringDecorator(new AdditionalLogger()).decorate(new ChromeDriver());
        driver.get("https://magento.softwaretestingboard.com/");

    }


    @Test
    @Feature("Login")
    @DisplayName("Login Positive Test")
    void LoginPositTest(){
        mainPage.clickSignInButton()
                .login("adkogan@gmail.com", "12345678ZXc");
        Assertions.assertTrue(mainPage.registerSuccessMessageIsDisplayed());
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
