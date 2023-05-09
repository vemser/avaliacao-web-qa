package br.com.dbccompany.vemser.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import br.com.dbccompany.vemser.utils.Elementos;

public class SearchPage extends Elementos{
    public static class Busca {
        private static final String SELETOR_CAMPO_FILTRO_NOME_ESTAGIARIO = "#nome";
        public static void filtrarEstagiarioPorNome(String string) {
            preencher(SELETOR_CAMPO_FILTRO_NOME_ESTAGIARIO, string);
        }
        public static void esperarBuscaPorNome(String nomeEstagiario) {
            Tabela.esperarCoincidirTextoPorRowIndexDataField("0", "nome", nomeEstagiario);
        }
    }
    public static class Tabela {
        private static final String SELETOR_COLUNA_POR_DATAFIELD = "div.MuiDataGrid-row [data-field='%s']";
        private static final String SELETOR_TEXTO_POR_DATAFIELD_POR_ID = "[data-id='%s'] [data-field='%s'] > div";
        private static final String SELETOR_COLUNA_ACOES_BOTOES = "[data-field='acoes'] [title*='Botão']";
        private static final String SELETOR_TEXTO_POR_ROWINDEX_DATAFIELD = "[data-rowindex='%s'] [data-field='%s']";

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
        public static void clicarBotaoDetalhes() {
            esperarConteudoNaoVazio(SELETOR_COLUNA_ACOES_BOTOES);
            driver.findElements(By.cssSelector(SELETOR_COLUNA_ACOES_BOTOES))
                .stream()
                .filter(webElement -> webElement.getAttribute("innerHTML").contains("Detalhes"))
                .findFirst()
                .ifPresent(WebElement::click);
        }
        public static void esperarCoincidirTextoPorRowIndexDataField(String rowIndex, String dataField, String texto) {
            esperarConteudoNaoVazio(String.format(SELETOR_TEXTO_POR_ROWINDEX_DATAFIELD, rowIndex, dataField));
            wait.until(ExpectedConditions.textToBePresentInElementLocated(By.cssSelector(String.format(SELETOR_TEXTO_POR_ROWINDEX_DATAFIELD, rowIndex, dataField)), texto));
        }
    }
}
