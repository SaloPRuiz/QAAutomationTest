package com.magento.pages;

import com.magento.utils.Variable;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.JavascriptExecutor;

import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage {
    
    public LoginPage(WebDriver driver2) {
        super(driver2);
        visit(Variable.BASE_URL);
    }
    
    By userInput = By.id("0000000002_frmLogin_inUsuario");
    By passInput = By.id("0000000003_frmLogin_inPassword");
    By bntLogin = By.id("0000000004_frmLogin_btnIngresar");
    
    public void fillOutFormData(String sUser, String sPass) {
        type(userInput, sUser);
        type(passInput, sPass);
        WebElement buttonLog = driver.findElement(bntLogin);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", buttonLog);
    }
}

