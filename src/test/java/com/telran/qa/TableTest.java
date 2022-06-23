package com.telran.qa;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TableTest {

    WebDriver wd;

    @BeforeMethod
    public void setUp() {
        wd = new ChromeDriver();
        wd.get("https://www.w3schools.com/css/css_table.asp");
        wd.manage().window().maximize();
        wd.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    @Test
    public void tableTestWithCss(){
        System.out.println(wd.findElement(By.cssSelector("tr:nth-child(4)")).getText()); // get row 4 in table
        System.out.println(wd.findElement(By.cssSelector("tr:nth-child(4) td:nth-child(3)")).getText());
        System.out.println(wd.findElement(By.cssSelector("tr:nth-child(4) td:last-child")).getText());
        System.out.println(wd.findElements(By.cssSelector("tr th")).size());
    }

    @AfterMethod
    public void tearDawn() {
        wd.quit();
    }
}
