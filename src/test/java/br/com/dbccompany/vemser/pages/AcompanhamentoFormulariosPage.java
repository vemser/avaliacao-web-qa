package br.com.dbccompany.vemser.pages;


import br.com.dbccompany.vemser.utils.Elementos;
import br.com.dbcompany.vemser.model.AcompanhamentoModel;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

/*
    private String titulo;
    private String dataInicio;
    private String dataFim;
    private Time horaInicio;
    private Time horaFim;
    private int sessao;
    private int resposaveis;
    private String descricao;
*/

public class AcompanhamentoFormulariosPage extends Elementos {
    static MenuPage menu = new MenuPage();
    private static final String BTN_ACOMPANHAMENTO = "#root > div.MuiBox-root.css-s8njx9 > div > div:nth-child(3) > div.MuiBox-root.css-0";
    private static final String BTN_CRIAR_ACOMPANHAMENTO = "[data-testid='programas-create-btn']";
    private static final String CAMPO_TITULO = "#titulo";
    private static final String CAMPO_DROPDOWN_INSTRUTORES ="[data-testid=\"selectInstrutores\"] > input";
    private static final String CAMPO_DATA_INICIO = "#dataInicio";
    private static final String CAMPO_DATA_FIM = "#dataFim";
    private static final String CAMPO_HORA_INICIO= "#horarioInicio";
    private static final String CAMPO_HORA_FIM= "#horarioFim";
    private static final String CAMPO_SESSAO= "#duracao";
    private static final String CAMPO_RESPONSAVEIS= "#numeroResponsaveis";
    private static final String CAMPO_DESCRICAO= "#descricao";
    private static final String BTN_SUBMIT_ACOMPANHAMENTO = "div#root button";

    // Métodos de CLICAR
    public static void clicarAcompanhamento() {
        clicar(BTN_ACOMPANHAMENTO);
    }
    public static void clicarCriarAcompanhamento() {
        clicar(BTN_CRIAR_ACOMPANHAMENTO);
    }
    public static void clicarSubmitAcompanhamento() {
        clicar(BTN_SUBMIT_ACOMPANHAMENTO);
    }

    // Métodos de MENSAGEM

    // Teste de caracteres maximos
    public String msgRetornoSucesso(){
        return Elementos.Modal.consultarMensagemModal();
    }
    public void preencherAcompanhamentoValido(AcompanhamentoModel acompanhamento){
        preencher(CAMPO_TITULO, acompanhamento.getTitulo());
        WebElement campoInstrutores = driver.findElement(By.cssSelector(CAMPO_DROPDOWN_INSTRUTORES));
        campoInstrutores.sendKeys(Keys.ENTER, Keys.DOWN, Keys.DOWN, Keys.ENTER);
        preencher(CAMPO_DATA_INICIO, acompanhamento.getDataInicio());
        preencher(CAMPO_DATA_FIM, acompanhamento.getDataFim());
        preencher(CAMPO_HORA_INICIO, acompanhamento.getHoraInicio());
        preencher(CAMPO_HORA_FIM, acompanhamento.getHoraFim());
        preencher(CAMPO_SESSAO, String.valueOf(acompanhamento.getSessao()));
        preencher(CAMPO_RESPONSAVEIS, String.valueOf(acompanhamento.getResposaveis()));
        preencher(CAMPO_DESCRICAO, acompanhamento.getDescricao());
        clicarSubmitAcompanhamento();
        esperarTempo(3000);
    }

    public void fluxoAcompanhamento(){
        menu.clicarBotaoConfiguracoes();
        clicarAcompanhamento();
        clicarCriarAcompanhamento();
    }

    public static void preencherDeAcompanhamentoHorariosIguais(){

    }





}
