package com.magento.steps;

import com.magento.pages.ComprobanteFacPage;
import com.magento.pages.HomePage;
import com.magento.pages.LoginPage;
import com.magento.pages.RegisterPage;
import com.magento.utils.Hooks;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.io.Console;
import java.util.List;
import java.util.Map;

public class FacturaSteps {

    public RegisterPage registerPage;
    public LoginPage loginPage;
    public HomePage homePage;
    public ComprobanteFacPage comprobanteFacPage;

    public FacturaSteps() {
        homePage = new HomePage(Hooks.driver);
        registerPage = new RegisterPage(Hooks.driver);
        loginPage = new LoginPage(Hooks.driver);
        comprobanteFacPage = new ComprobanteFacPage(Hooks.driver);
    }

    @Given("usuario logueado")
    public void usuario_logueado(DataTable dataTable) {
        // Convertir la tabla de datos a una lista de mapas
        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);

        String username = "";
        String password = "";
        
        
        for (Map<String, String> row : data) {
            username = row.get("Username");
            password = row.get("Password");
            
            System.out.println(username + "," + password);
            
        }
        loginPage.fillOutFormData(username, password);
        homePage.irFactura();
    }

    @When("Se ingresan los datos de cliente e items")
    public void se_ingresan_los_datos_de_cliente_e_items() {
        comprobanteFacPage.datosCliente();
        comprobanteFacPage.agregarItemManual();
    }

    @When("Se presiona emitir")
    public void se_presiona_emitir() 
    {
        comprobanteFacPage.clickButtonEmitir();
    }

    @Then("Aparece la vista del pdf de la factura emitida")
    public void aparece_la_vista_del_pdf_de_la_factura_emitida()
    {
        comprobanteFacPage.validarDocumentoEmitido();
    }
}
