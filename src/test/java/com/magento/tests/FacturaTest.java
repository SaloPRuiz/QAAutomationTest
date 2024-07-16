package com.magento.tests;

import org.testng.annotations.Test;


public class FacturaTest extends BaseTest {

    @Test
    public void facturaSimple(){
        loginPage.fillOutFormData("demo-pvlg", "demo123");
        homePage.irFactura();
        comprobanteFacPage.datosCliente();
        comprobanteFacPage.datosDocumento();
        comprobanteFacPage.agregarItemManual();
        //comprobanteFacPage.agregarItemLogistico();
        comprobanteFacPage.clickButtonEmitir();
        comprobanteFacPage.validarDocumentoEmitido();
    }
}

