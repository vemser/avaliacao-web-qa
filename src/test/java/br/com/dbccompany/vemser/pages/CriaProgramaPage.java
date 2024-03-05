package br.com.dbccompany.vemser.pages;

import br.com.dbccompany.vemser.utils.Elementos;
import br.com.dbcompany.vemser.model.CriaProgramaModel;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

public class CriaProgramaPage extends Elementos {
    private static final String CAMPO_NOME = "#nome";
    private static final String CAMPO_DATA_INICIAL = "#dataInicio";
    private static final String CAMPO_DATA_FINAL = "#dataFim";
    private static final String CAMPO_DESCRICAO = "#descricao";
    private static final String CAMPO_STATUS = "#status";
    private static final String BTN_CRIAR_PROGRAMA = "div#root button[type=\"submit\"]";

    // Métodos para PREENCHER
    public void preencherNome(String nome){
        preencher(CAMPO_NOME, nome);
    }
    public void preencherDataInicial(String dataInicial){
        preencher(CAMPO_DATA_INICIAL, dataInicial);
    }
    public void preencherDataFinal(String dataFinal){
        preencher(CAMPO_DATA_FINAL, dataFinal);
    }
    public void preencherDescricao(String descricao){
        preencher(CAMPO_DESCRICAO, descricao);
    }
    public void preencherStatus(String status){
        preencher(CAMPO_STATUS, status);
    }

    // Métodos de RETORNO
    public String mensagensModal(){
        Elementos.Modal.esperarModalAbrir();
        return Elementos.Modal.consultarMensagemModal();
    }

    // Métodos para CLICAR
    public void clicarCriarPrograma(){
        clicar(BTN_CRIAR_PROGRAMA);
    }

    // Métodos completos
    public void preencherPrograma(CriaProgramaModel programa){
        WebElement campoStatus = driver.findElement(By.cssSelector(CAMPO_STATUS));
        preencherNome(programa.getNome());
        preencherDataInicial(programa.getDataInicial());
        preencherDataFinal(programa.getDataFinal());
        preencherDescricao(programa.getDescricao());
        campoStatus.sendKeys(Keys.chord(Keys.RETURN, Keys.DOWN, Keys.RETURN));
        clicarCriarPrograma();
        esperarTempo(4000);
    }

}
