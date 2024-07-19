package com.magento.steps;

import com.magento.tests.FacturaTest;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class FacturaSteps {
 
    FacturaTest facturaTest;

    public FacturaSteps() {
        facturaTest = new FacturaTest();
    }
    
    @Given("usuario logueado")
    public void usuario_logueado() {
        facturaTest.loginPage.fillOutFormData("demo-pvlg", "demo123");
        facturaTest.homePage.irFactura();
    }
    @When("Se ingresan los datos de cliente e items")
    public void se_ingresan_los_datos_de_cliente_e_items() {
        facturaTest.comprobanteFacPage.datosCliente();
        facturaTest.comprobanteFacPage.agregarItemManual();
    }
    @When("Se presiona emitir")
    public void se_presiona_emitir() {
        facturaTest.comprobanteFacPage.clickButtonEmitir();
    }
    @Then("Aparece la vista del pdf de la factura emitida")
    public void aparece_la_vista_del_pdf_de_la_factura_emitida() {
        facturaTest.comprobanteFacPage.validarDocumentoEmitido();
    }
}
