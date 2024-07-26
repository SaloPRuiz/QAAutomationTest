package com.magento.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {

    WebDriver driver;
    WebDriverWait wait;
    int timeOutSec=10;

    public BasePage (WebDriver driver){
        this.driver=driver;
        wait=new WebDriverWait(driver, Duration.ofSeconds(timeOutSec));
    }

    public void setTimeOutSec(int timeOutSec){
        this.timeOutSec=timeOutSec;
    }

    public void visit(String url){
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(timeOutSec));
        driver.get(url);

    }

    public WebElement find(By element){
        return driver.findElement(element);
    }

    public void  click(By element){
        find(element).click();
    }

    public void type(By element, String text){
        find(element).sendKeys(text);
    }

    public void type(WebElement element, String text){
        element.sendKeys(text);
    }
    
    public void select(By element, String text){
        Select cb = new Select(find(element));
        cb.selectByVisibleText(text);

    }

    public void select(WebElement element, String text){
        Select cb = new Select(element);
        cb.selectByVisibleText(text);

    }
    
    public void selectByValue(By element, String text){
        Select cb = new Select(find(element));
        cb.selectByValue(text);
    }

    public boolean isDisplay(By locator){
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        } catch (Exception e){
            return false;
        }
        return true;
    }

}
