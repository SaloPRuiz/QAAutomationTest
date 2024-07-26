package com.magento.utils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import io.cucumber.java.Before;

import java.time.Duration; 

public class Hooks {
    private final WebDriver driver;

    public Hooks(WebDriver driver) {
        this.driver = driver;
    }
    
    @Before
    public void setUp() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }
}
