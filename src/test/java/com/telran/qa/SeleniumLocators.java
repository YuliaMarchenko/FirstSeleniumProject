package com.telran.qa;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class SeleniumLocators {

    WebDriver wd;

    @BeforeMethod
    public void setUp() {
        wd = new ChromeDriver();
        wd.get("https://ilcarro-1578153671498.web.app/registration?url=%2Fsearch");
        wd.manage().window().maximize();
        wd.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    @Test
    public void startFindLocators() {
        wd.findElement(By.id("name"));
        wd.findElement(By.id("lastName"));
        wd.findElement(By.id("email"));
        wd.findElement(By.id("password"));
        wd.findElement(By.className("input-label"));
        wd.findElement(By.name("viewport"));
        System.out.println(wd.findElement(By.linkText("Let the car work")).getText());
        System.out.println(wd.findElement(By.partialLinkText("car")).getText());
    }

    @Test
    public void startFindCss() {
        wd.findElement(By.cssSelector("div")); // wd.findElement(By.tagName("div"));
        wd.findElement(By.cssSelector("#name")); // wd.findElement(By.id("name"));
        wd.findElement(By.cssSelector(".input-label")); // wd.findElement(By.className("input-label"));
        wd.findElement(By.cssSelector("[href='/search']")); //attribute --> []
        wd.findElement(By.cssSelector("[for='password']")); //attribute
        wd.findElement(By.cssSelector("[for*='ssw']")); //attribute --> contains "ssw"
        wd.findElement(By.cssSelector("[for^='pas']")); //attribute --> start with "pas" --> ^
        wd.findElement(By.cssSelector("[for$='rd']")); //attribute --> end on "rd" --> $
    }

    @Test
    public void startFindXpath() {
        // "//*[@attr='value']"
        wd.findElement(By.xpath("//div")); // wd.findElement(By.tagName("div"));
        wd.findElement(By.xpath("//*[@id='email']")); // wd.findElement(By.id("name"));
        wd.findElement(By.xpath("//input[@id='email']"));
        wd.findElement(By.xpath("//*[@class='input-label']")); // wd.findElement(By.className("input-label"));
        wd.findElement(By.xpath("//*[@href='/search']")); //wd.findElement(By.cssSelector("[href='/search']"));
        wd.findElement(By.xpath("//*[starts-with(@for,'pas')]")); // start with "pas"
        wd.findElement(By.xpath("//*[contains(.,'ssw')]")); // contains "ssw"
        wd.findElement(By.xpath("//*[contains(.,'rd')]")); // end on "rd", same as contains
    }

    @AfterMethod
    public void tearDawn() {
        wd.quit();
    }
}
