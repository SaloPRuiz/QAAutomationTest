package com.magento.tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class FacturaTest extends BaseTest {
    
    @Test(dataProvider = "users")
    public void facturaSimple(String s1, String s2){
        loginPage.fillOutFormData(s1, s2);
        homePage.irFactura();
        comprobanteFacPage.datosCliente();
        //comprobanteFacPage.datosDocumento();
        comprobanteFacPage.agregarItemManual();
        //comprobanteFacPage.agregarItemLogistico();
        comprobanteFacPage.clickButtonEmitir();
        comprobanteFacPage.validarDocumentoEmitido();
    }

    @DataProvider(name = "users")
    public Object[][] dataProviderMethod() {
        return new Object[][]{
                {"demo-pvlg", "demo123"},
                {"giros-demo", "12345"},
                {"altas-aqp", "12345"}
        };
    }
}

