package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
    WebDriver driver;
    public LoginPage(WebDriver driver){
        this.driver = driver;
    }

    public WebElement userName(){
        return  driver.findElement(By.xpath("//*[@id=\"username\"]"));
    }
    public WebElement password(){
        return  driver.findElement(By.xpath("//*[@id=\"password\"]"));
    }
    public WebElement submitButton(){
        return  driver.findElement(By.xpath("//*[@id=\"submit\"]"));
    }
    public WebElement messageError(){
        return  driver.findElement(By.xpath("//*[@id=\"error\"]"));
    }
    public WebElement loginStatus(){
        return  driver.findElement(By.xpath("//*[@id=\"loop-container\"]/div/article/div[1]/h1"));
    }


}
