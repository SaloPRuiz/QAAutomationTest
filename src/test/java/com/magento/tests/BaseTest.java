package com.magento.tests;

import com.magento.pages.ComprobanteFacPage;
import com.magento.pages.HomePage;
import com.magento.pages.LoginPage;
import com.magento.pages.RegisterPage;
import com.magento.utils.Variable;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class BaseTest {
    protected static WebDriver driver;
    protected RegisterPage registerPage;
    public LoginPage loginPage;
    public HomePage homePage;
    public ComprobanteFacPage comprobanteFacPage;
    
    @BeforeMethod
    public void setup(){
        driver= new EdgeDriver();//instanciando el objeto driver

        homePage= new HomePage(driver);
        registerPage=new RegisterPage(driver) ;
        loginPage=new LoginPage(driver);
        comprobanteFacPage=new ComprobanteFacPage(driver);

    }

    @AfterMethod
    public void teardown(){
        if (driver!=null){
            //driver.quit();
        }

    }

}
