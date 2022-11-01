package ru.gb.lesson3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Headhunter {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();
        driver.get("https://hh.ru/");

        //Type in "QA junior"
        driver.findElement(By.cssSelector("[data-qa ='search-input']")).sendKeys("QA junior");
        driver.findElement(By.cssSelector("[data-qa ='advanced-search']")).click();

        WebDriverWait webDriverWait=new WebDriverWait(driver, Duration.ofSeconds(3));
        webDriverWait.withTimeout(Duration.ofSeconds(3));

        //driver.findElement(By.cssSelector("[data-qa='control-vacancysearch__search_field-item control-vacancysearch__search_field-item_name']")).click();
        driver.findElement(By.xpath("//input[contains(@data-qa,'control-vacancysearch__search_field-item control-vacancysearch__search_field-item_name')]/parent::label")).click();

        driver.findElement(By.cssSelector("[data-qa='resumesearch__profroles-switcher']")).click();

        driver.findElement(By.cssSelector("[data-qa='bloko-tree-selector-toogle-node bloko-tree-selector-toogle-node-category-11']")).click();


        driver.findElement(By.cssSelector("[data-qa='bloko-tree-selector-item-text bloko-tree-selector-item-text-124']")).click();
        driver.findElement(By.cssSelector("[data-qa='bloko-tree-selector-popup-submit']")).click();
        driver.findElement(By.cssSelector("[data-qa='advanced-search-salary']")).sendKeys("20000");

        driver.findElement(By.cssSelector("[data-qa='advanced-search__experience-item-label_noExperience']")).click();

        driver.findElement(By.cssSelector("[data-qa='advanced-search-submit-button']")).click();



        //Thread.sleep(5000);
        driver.quit();


    }
}
