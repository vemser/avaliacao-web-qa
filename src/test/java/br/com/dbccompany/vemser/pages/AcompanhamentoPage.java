package br.com.dbccompany.vemser.pages;


import br.com.dbccompany.vemser.utils.Elementos;
import br.com.dbccompany.vemser.utils.Navegador;
import br.com.dbcompany.vemser.model.AcompanhamentoModel;
import org.checkerframework.checker.units.qual.A;

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

public class AcompanhamentoPage extends Elementos {
    static LoginPage login = new LoginPage();
    static AcessoPage acesso = new AcessoPage();
    static ConfiguracoesPage configuracoesPage = new ConfiguracoesPage();
    static MenuPage menu = new MenuPage();
    private static final String BTN_ACOMPANHAMENTO = "#root > div.MuiBox-root.css-s8njx9 > div > div:nth-child(3) > div.MuiBox-root.css-0";
    private static final String BTN_PROGRAMA_ATIVO = "#root > div.MuiBox-root.css-s8njx9 > div > div:nth-child(3) > div.MuiBox-root.css-0";
    private static final String BTN_CRIAR_ACOMPANHAMENTO = "[data-testid='programas-create-btn']";
    private static final String CAMPO_TITULO = "#titulo-label";
    private static final String CAMPO_DATA_INICIO = "#dataInicio-label";
    private static final String CAMPO_DATA_FIM = "#dataFim-label";
    private static final String CAMPO_HORA_INICIO= "#horaInicio-label";
    private static final String CAMPO_HORA_FIM= "#horaFim-label";
    private static final String CAMPO_SESSAO= "#duracao-label";
    private static final String CAMPO_RESPONSAVEIS= "#numeroResponsaveis-label";
    private static final String CAMPO_DESCRICAO= "#descricao-label";

    public static void clicarAcompanhamento() {
        clicar(BTN_ACOMPANHAMENTO);
    }
    public static void clicarCriarAcompanhamento() {
        clicar(BTN_CRIAR_ACOMPANHAMENTO);
    }

    public static void preencherDeAcompanhamentoValido(AcompanhamentoModel acompanhamento){
        preencher(CAMPO_TITULO, acompanhamento.getTitulo());
        preencher(CAMPO_DATA_INICIO, acompanhamento.getDataInicio());
        preencher(CAMPO_DATA_FIM, acompanhamento.getDataFim());
        preencher(CAMPO_HORA_INICIO, acompanhamento.getHoraInicio());
        preencher(CAMPO_HORA_FIM, acompanhamento.getHoraFim());
        preencher(CAMPO_SESSAO, String.valueOf(acompanhamento.getSessao()));
        preencher(CAMPO_RESPONSAVEIS, String.valueOf(acompanhamento.getResposaveis()));
        preencher(CAMPO_DESCRICAO, acompanhamento.getDescricao());
    }

    public static void fluxoDeLogin(){
        login.realizarLoginComSucesso();
        acesso.clicarBotaoAvaliacao();
    }

    public static void fluxoAcompanhamento(){
        menu.clicarBotaoConfiguracoes();
        clicarAcompanhamento();
        clicarCriarAcompanhamento();
    }

    public static void preencherDeAcompanhamentoHorariosIguais(){

    }





}
