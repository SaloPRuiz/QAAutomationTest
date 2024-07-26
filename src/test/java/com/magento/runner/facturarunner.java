package com.magento.runner;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",//ruta donde se encuentran los features
        glue = {"com.magento.steps", "com.magento.utils"}, //ruta donde se encuentra los step definitions
        plugin = {"pretty","summary",
                "html:target/test-report.html",
                "json:target/cucumber.json",
                "junit:target/cucumber.xml"},
        monochrome = false,
        publish = true,
        dryRun = false,
        tags = "@scenario01"

)
public class facturarunner {
}   
