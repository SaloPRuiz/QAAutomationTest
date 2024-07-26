package com.magento.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.yaml.snakeyaml.events.Event;

import java.io.Console;
import java.util.regex.Pattern;

public class ComprobanteFacPage extends BasePage {

    public ComprobanteFacPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    // Define los elementos usando @FindBy
    @FindBy(id = "04010103010_btnAgregarItemmanual")
    private WebElement buttonProductoManual;

    @FindBy(xpath = "//textarea[@formcontrolname='descripcionItem']")
    private WebElement textDescripcionItemManual;

    @FindBy(xpath = "//input[@formcontrolname='precioUnitario']")
    private WebElement inputPrecioItemManual;

    @FindBy(xpath = "(//app-agregar-item-manual//button)[2]")
    private WebElement buttonAceptarIemManual;

    @FindBy(id = "0401010302_frBusquedaItem_btnEmitir")
    private WebElement buttonEmitir;
    

    //Datos del cliente
    By selectTipoDocCliente = By.xpath("//select[@id='tipoDocumentoCliente']");

    By selectTipoDocClienteValidation = By.xpath("//select[@id='tipoDocumentoCliente']/option");

    By inputDocCliente = By.xpath("//input[@id='dniRuc']");
    By buttonSearchDocCliente = By.xpath("//button[@ngbtooltip='Buscar entidad']");


    //Agregar producto manual
    //By buttonProductoManual = By.id("04010103010_btnAgregarItemmanual");
    
    // By textDescripcionItemManual=By.xpath("//textarea[@formcontrolname='descripcionItem']");
    // By inputPrecioItemManual=By.xpath("//input[@formcontrolname='precioUnitario']");
    // By buttonAceptarIemManual=By.xpath("(//app-agregar-item-manual//button)[2]");

    //By buttonEmitir=By.id("0401010302_frBusquedaItem_btnEmitir");
    
    By iframeElement = By.tagName("iframe");

    // SWAL-ALERT
    @FindBy(id = "swal2-content")
    private WebElement swalTextLocator;

    // Razon-socialinpuit
    By inputRazonSocial = By.id("RazonSocial");


    public void datosCliente() {
        int intentos = 0;
        int intentosMaximos = 5;
        boolean llenadoExitoso = false;
        Pattern pattern = Pattern.compile("^.+$");

        while (intentos < intentosMaximos && !llenadoExitoso) {
            try {
                wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(selectTipoDocClienteValidation, 1));
                llenadoExitoso = true; // Si llega aquí sin lanzar excepción, el llenado fue exitoso
                System.out.println("El select se llenó");
                select(selectTipoDocCliente, "RUC");
                type(inputDocCliente,"10725709400");
                WebElement buttonSearchDocClientev2 = driver.findElement(buttonSearchDocCliente);
                ((JavascriptExecutor) driver).executeScript("arguments[0].click();", buttonSearchDocClientev2);
                wait.until(driver -> {
                    String value = driver.findElement(inputRazonSocial).getAttribute("value");
                    System.out.println("Value in input field: " + value);
                    return value != null && !value.isEmpty();
                });
                
            } catch (TimeoutException e) {
                System.out.println("El select no se llenó a tiempo, intentando nuevamente...");
                driver.navigate().refresh(); // Refrescar la página
                intentos++;
            }
        }

        if (!llenadoExitoso) {
            throw new TimeoutException("No se pudo llenar el select después de " + intentos + " intentos.");
        }
    }

    public void agregarItemManual(){

        System.out.println("Se entra a agregar 1");
        // WebElement btnProductoManual = driver.findElement(buttonProductoManual);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", buttonProductoManual);
        System.out.println("Se entra a agregar 2");
        type(textDescripcionItemManual,"Item manual desde automatizacion");
        System.out.println("Se entra a agregar 3");
        type(inputPrecioItemManual,"72");
        // WebElement btnAceptarIemManual = driver.findElement(buttonAceptarIemManual);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", buttonAceptarIemManual);

    }
    
    public void  clickButtonEmitir(){
       //  WebElement btnEmitir = driver.findElement(buttonEmitir);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", buttonEmitir);
    }
    
    public void validarDocumentoEmitido(){
        wait.until(ExpectedConditions.visibilityOf(swalTextLocator));
        // WebElement swalTextElement = driver.findElement(swalTextLocator);
        String actualSwalText = swalTextLocator.getText();
        String expectedSwalText = "Se Emitió el Documento";

        Assert.assertEquals(expectedSwalText, actualSwalText);
        
        System.out.println("El texto del swal es: " + actualSwalText);
        
        
        wait.until(ExpectedConditions.presenceOfElementLocated(iframeElement));
            
        System.out.println("EL DOCUMENTO YA ESTA EMITIDO");
    }
}
