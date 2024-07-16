package com.magento.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import java.io.Console;

public class ComprobanteFacPage extends BasePage{

    public  ComprobanteFacPage(WebDriver driver){
        super(driver);
    }

    //Datos del cliente
    By selectTipoDocCliente = By.xpath("//select[@id='tipoDocumentoCliente']");
    By selectTipoDocClienteValidation = By.xpath("//select[@id='tipoDocumentoCliente']/option");
    By inputDocCliente= By.xpath("//input[@id='dniRuc']");
    By buttonSearchDocCliente =By.xpath("//button[@ngbtooltip='Buscar entidad']");


    //Datos del documento
    By selecsSerieDocsValidation = By.xpath("//*[@id=\"0401040203_frmDd_cklSerieDocumento\"]/option");
    By selectSerieDocs = By.id("0401040203_frmDd_cklSerieDocumento");
    By selectMonedaDocs =By.id("0401040204_frmDd_cklMonedaDocumento");
    By selectCondicionPagoDoc=  By.id("condicionPagoDocumento");
    By selectFechaEmiDoc= By.id("fechaEmisionCompient");
    By selectIGVDoc =By.id("0401040204_frmDd_cklListaIgv");

    By checkExportacionDoc=  By.id("checkbox16");
    By checkDetraccion=By.id("detraccion");
    By checkRetencion=By.id("retencion");

    //Adeolantos
    By titleAdelanto= By.xpath("//p[contains(text(),'Adelantos (Clic para Desplegar)')]");
    By buttonAdelantos=By.xpath("//button[@id='401040109_dvApl_adelanto']");

    //Agregar producto manual
    By buttonProductoManual=By.id("04010103010_btnAgregarItemmanual");

    //Agregar producto logistico
    By buttonProductoLogistico=By.id("04010103010_btnAgregarItem");
    By selectTipoBusqueda=By.name("tipo_busqueda");
    By inputBusquedaItem=By.id("04010103021_frBusquedaItem_inDescripcion");
    //
    By textDescripcionItemManual=By.xpath("//textarea[@formcontrolname='descripcionItem']");
    By inputPrecioItemManual=By.xpath("//input[@formcontrolname='precioUnitario']");
    By buttonAceptarIemManual=By.xpath("(//app-agregar-item-manual//button)[2]");

    By buttonEmitir=By.id("0401010302_frBusquedaItem_btnEmitir");
    By iframeElement = By.tagName("iframe");




    public void datosCliente() {
        wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(selectTipoDocClienteValidation, 1));
        
        select(selectTipoDocCliente, "RUC");
        type(inputDocCliente,"10725709400");
        WebElement buttonSearchDocClientev2 = driver.findElement(buttonSearchDocCliente);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", buttonSearchDocClientev2);
    }

    public void datosDocumento(){
        wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(selecsSerieDocsValidation, 1));
        
        select(selectSerieDocs, "F100");
        select(selectMonedaDocs,"SOLES");
        select(selectCondicionPagoDoc,"CONTADO");
        //type(selectFechaEmiDoc,"10/04/2024");
        select(selectIGVDoc, "IGV 18%");
        //SELECCION DE DETRACCION

    }

    public void agregarItemManual(){

        System.out.println("Se entra a agregar 1");
        WebElement btnProductoManual = driver.findElement(buttonProductoManual);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", btnProductoManual);
        System.out.println("Se entra a agregar 2");
        type(textDescripcionItemManual,"Item manual desde automatizacion");
        System.out.println("Se entra a agregar 3");
        type(inputPrecioItemManual,"72");
        WebElement btnAceptarIemManual = driver.findElement(buttonAceptarIemManual);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", btnAceptarIemManual);

    }
    public void agregarItemLogistico(){
        WebElement btnProductoLogistico = driver.findElement(buttonProductoLogistico);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", btnProductoLogistico);
        select(selectTipoBusqueda,"Código");
        type(inputBusquedaItem,"B600161826");
    }

    public void  llenarDatosPieDocumento(){

    }
    public void  clickButtonEmitir(){
        WebElement btnEmitir = driver.findElement(buttonEmitir);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", btnEmitir);
    }
    
    public void validarDocumentoEmitido(){
        //String textoValidacion = "Se Emitió el Documento";
        
        wait.until(ExpectedConditions.presenceOfElementLocated(iframeElement));
        //Assert.assertEquals(abc,textoValidacion);
            
        System.out.println("EL DOCUMENTO YA ESTA EMITIDO");
    }


}
