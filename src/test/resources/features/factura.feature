Feature: Emision de factura
  Como usuario logueado
  Quiero poder emitir una factura
  Para validar la compra de mi cliente

  @scenario01
  Scenario: Emision simple
    Given usuario logueado
      |Username|Password|
      |demo-pvlg|demo123|
      |fami-aqp|12345|
      |altas-aqp|12345|
    When Se ingresan los datos de cliente e items
    And Se presiona emitir
   Then Aparece la vista del pdf de la factura emitida
    
  @multiple
  Scenario Outline: Emision de factura con diferentes usuarios
    Given usuario logueado
      | Username   | Password |
      | <username> | <password> |
    When Se ingresan los datos de cliente e items
    And Se presiona emitir
    Then Aparece la vista del pdf de la factura emitida

    Examples:
      | username | password |
      | demo-pvlg | demo123  |
      | fami-aqp  | 12345    |
      | altas-aqp | 12345    |
    