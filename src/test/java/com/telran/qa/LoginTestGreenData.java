package com.telran.qa;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTestGreenData extends TestClass{

    @BeforeMethod
    public void ensurePrecondition(){
        if (isUserLogin()){
            click(By.cssSelector("#userName"));
            click(By.xpath("//*[text() = 'Выход']"));
        }
    }

    @Test
    public void loginUserPositiveTest(){
        login();
        Assert.assertTrue(isElementPresent(By.xpath("//*[text() = 'Иванов (QA. test)']")));
    }

}
