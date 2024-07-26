package com.magento.steps;

import com.magento.pages.ComprobanteFacPage;
import com.magento.pages.HomePage;
import com.magento.pages.LoginPage;
import com.magento.pages.RegisterPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

public class FacturaSteps {
    private final WebDriver driver;
    public RegisterPage registerPage;
    public LoginPage loginPage;
    public HomePage homePage;
    public ComprobanteFacPage comprobanteFacPage;


    public FacturaSteps(WebDriver driver) {
        this.driver = driver;
        this.homePage = new HomePage(driver);
        this.registerPage = new RegisterPage(driver);
        this.loginPage = new LoginPage(driver);
        this.comprobanteFacPage = new ComprobanteFacPage(driver);
    }

    @Given("usuario logueado")
    public void usuario_logueado() {
        loginPage.fillOutFormData("demo-pvlg", "demo123");
        homePage.irFactura();
    }

    @When("Se ingresan los datos de cliente e items")
    public void se_ingresan_los_datos_de_cliente_e_items() {
        comprobanteFacPage.datosCliente();
        comprobanteFacPage.agregarItemManual();
    }

    @When("Se presiona emitir")
    public void se_presiona_emitir() {
        comprobanteFacPage.clickButtonEmitir();
    }

    @Then("Aparece la vista del pdf de la factura emitida")
    public void aparece_la_vista_del_pdf_de_la_factura_emitida() {
        comprobanteFacPage.validarDocumentoEmitido();
    }
}
