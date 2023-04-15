package br.com.dbccompany.vemser.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Tabelas extends Elementos {
    public static final String SELETOR_COLUNA_ID = "div.MuiDataGrid-row [data-field=\"id\"]";
    public static List<String> consultarIds(int quantidade) {
        return driver.findElements(By.cssSelector(SELETOR_COLUNA_ID)).stream().map(WebElement::getText).limit(quantidade).toList();
    }
}
