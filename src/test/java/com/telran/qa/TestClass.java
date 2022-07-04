package com.telran.qa;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public class TestClass {

    /*Создайте, пожалуйста, тестовый класс(с отдельным @BeforeMethod и @AfterMethod) в проекте FirstSeleniumPpoject и
    создайте в нем тестовый метод для странички, где вы должны залогиниться с данными(логин/пароль: tester/K35G3U) и
    сделать Assert по имени пользователя в навигационной панели(Иванов QA.test).*/

    WebDriver wd;

    @BeforeMethod
    public void setUp() {
        wd = new ChromeDriver();
        wd.get("https://gdcloud.ru/release-17/auth/login.html#/?_k=gg6ctj");
        wd.manage().window().maximize();
        wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @AfterMethod
    public void tearDawn() {
        wd.quit();
    }

    public void login(){
        type(By.cssSelector("#username"), "tester");
        type(By.cssSelector("#password"), "K35G3U");
        click(By.cssSelector("#login_button"));
    }

    public void click(By locator) {
        wd.findElement(locator).click();
    }

    public void type(By locator, String str) {
        click(locator);
        wd.findElement(locator).clear();
        wd.findElement(locator).sendKeys(str);
    }

    public boolean isUserLogin(){
        return isElementPresent(By.cssSelector("#userName"));
    }

    public boolean isElementPresent(By locator){
        return wd.findElements(locator).size() > 0;
    }
}
