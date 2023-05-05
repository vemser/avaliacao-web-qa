package br.com.dbccompany.vemser.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Tabelas extends Elementos {
    public static final String SELETOR_COLUNA_POR_DATAFIELD = "div.MuiDataGrid-row [data-field='%s']";
    public static final String SELETOR_TEXTO_POR_DATAFIELD_POR_ID = "[data-id='%s'] [data-field='%s'] > div";

    public static List<String> consultarIds(int quantidade) {
        return consultarColunaPorDataField("id").stream().map(WebElement::getText).limit(quantidade).toList();
    }
    public static List<WebElement> consultarColunaPorDataField(String dataField) {
        return driver.findElements(By.cssSelector(String.format(SELETOR_COLUNA_POR_DATAFIELD, dataField)));
    }
    public static String consultarTextoPorDataIdDataField(String dataId, String dataField) {
        return consultarTexto(String.format(SELETOR_TEXTO_POR_DATAFIELD_POR_ID, dataId, dataField));
    }
    public static String consultarNomePorId(String id) {
        return consultarTexto(String.format(SELETOR_TEXTO_POR_DATAFIELD_POR_ID, id, "nome"));
    }
}
