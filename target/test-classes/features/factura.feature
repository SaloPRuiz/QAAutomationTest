Feature: Emision de factura
  Como usuario logueado
  Quiero poder emitir una factura
  Para validar la compra de mi cliente

  Background: Emision de comprobantes
    Given usuario logueado

  @scenario01
  Scenario: Emision simple
    When Se ingresan los datos de cliente e items
    And Se presiona emitir
   Then Aparece la vista del pdf de la factura emitida