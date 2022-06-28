package com.telran.qa;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class CssSelectorsXpath {
    WebDriver wd;

    @BeforeMethod
    public void setUp() {
        wd = new ChromeDriver();
        wd.get("http://automationpractice.com/index.php");
        wd.manage().window().maximize();
        wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void findCssSelectorsXpath() {
        wd.findElement(By.cssSelector(".header_user_info"));
        wd.findElement(By.xpath("//*[@class='header_user_info']"));

        wd.findElement(By.cssSelector("[title=\"Contact Us\"]"));
        wd.findElement(By.xpath("//*[@title=\"Contact Us\"]"));

        wd.findElement(By.cssSelector("#search_query_top"));
        wd.findElement(By.xpath("//*[@id='search_query_top']"));

        wd.findElement(By.cssSelector("[title*=\"View my\"]"));
        wd.findElement(By.xpath("//*[starts-with(@title,'View my')]"));

        wd.findElement(By.cssSelector("a[title=\"sample-2\"]  + div button"));
        wd.findElement(By.xpath("//a[@title='sample-2']/following-sibling::div//button"));

        wd.findElement(By.cssSelector(".active a[title*=\"Faded Short\"]"));
        wd.findElement(By.xpath("//ul[contains(@class,'active')]//a[starts-with(@title,'Faded Short')]"));

        wd.findElement(By.cssSelector(".active [data-id-product=\"1\"]"));
        wd.findElement(By.xpath("//ul[contains(@class,'active')]//*[@data-id-product=\"1\"]"));

        wd.findElement(By.cssSelector(".facebook-fanbox"));
        wd.findElement(By.xpath("//*[@class='facebook-fanbox']"));

        wd.findElement(By.cssSelector("[href*=\"https://www.facebook\"]"));
        wd.findElement(By.xpath("//*[starts-with(@href,'https://www.facebook')]"));

        wd.findElement(By.cssSelector("[value=\"Enter your e-mail\"]"));
        wd.findElement(By.xpath("//*[@value='Enter your e-mail']"));
    }

    @AfterMethod
    public void tearDawn() {
        wd.quit();
    }
}
