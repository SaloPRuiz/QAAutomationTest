package com.magento.steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import java.util.List;
import java.util.Map;

public class SesionSteps {
    @Given("informacion valida de inicio de sesion")
    public void informacionValidaDeInicioDeSesion(DataTable dataTable) {
        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);

        for (Map<String, String> row : data) {
            String username = row.get("Username");
            String password = row.get("Password");

            System.out.println(username + "," + password);
        }
    }

    @Then("Se inicia sesion")
    public void seIniciaSesion() {
    }
}
