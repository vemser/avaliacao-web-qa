package br.com.dbccompany.vemser.pages;

import br.com.dbccompany.vemser.utils.Elementos;

public class MenuPage extends Elementos {
    private static final String SELETOR_NOME_USUARIO = "div.MuiDrawer-docked > div > aside > div.MuiBox-root > p > span > strong";
    private static final String SELETOR_BOTAO_ACOMPANHAMENTOS = "[data-testid=\"acompanhamentos-menu-btn\"]";
    private static final String SELETOR_BOTAO_COMPORTAMENTAL = "body > div:nth-child(2) > div:nth-child(2) > div:nth-child(1) > aside:nth-child(1) > div:nth-child(3) > nav:nth-child(1) > div:nth-child(3) > div:nth-child(2) > span:nth-child(1)";
    private static final String SELETOC_BOTAO_ACOMPANHAMENTO_GP = "ul[class='MuiList-root MuiList-padding css-1ontqvh'] span[class='MuiTypography-root MuiTypography-body1 MuiListItemText-primary css-ikw04q']";
    private static final String SELETOR_BOTAO_CONFIGURACOES = "[data-testid=\"configuracoes-menu-btn\"]";
    private static final String SELETOR_BOTAO_DASHBOARD = "div[class='MuiPaper-root MuiPaper-elevation MuiPaper-elevation0 MuiDrawer-paper MuiDrawer-paperAnchorLeft MuiDrawer-paperAnchorDockedLeft css-1l8j5k8'] div:nth-child(1) div:nth-child(2) span:nth-child(1)";
    private static final String SELETOR_BOTAO_ESTAGIARIOS = "[data-testid=\"estagiarios-menu-btn\"]";
    private static final String SELETOR_BOTAO_MENU = "[data-testid=\"MenuIcon\"]";
    private static final String SELETOR_BOTAO_TECNICO = "[data-testid=\"tecnico-menu-btn\"]";
    private static final String SELETOR_BOTAO_TECNICO_FEEDBACK = "nav svg[data-testid=\"ThumbUpOutlinedIcon\"]";
    private static final String SELETOR_BOTAO_VOLTAR = "[data-testid=\"sair-menu-btn\"]";
    private static final String SELETOR_TITULO_ATUAL = "[data-testid*=\"header\"] h1";
    public static void clicarBotaoAcompanhamentos() {
        clicar(SELETOR_BOTAO_ACOMPANHAMENTOS);
    }
    public static void clicarBotaoComportamental() {
        clicar(SELETOR_BOTAO_COMPORTAMENTAL);
        clicar(SELETOC_BOTAO_ACOMPANHAMENTO_GP);
    }
    public void clicarBotaoConfiguracoes() {
        clicar(SELETOR_BOTAO_CONFIGURACOES);
    }
    public void clicarBotaoDashboard() {
        clicar(SELETOR_BOTAO_DASHBOARD);
    }
    public void clicarBotaoEstagiarios() {
        clicar(SELETOR_BOTAO_ESTAGIARIOS);
    }
    public void clicarBotaoMenu() {
        clicar(SELETOR_BOTAO_MENU);
    }
    public static void clicarBotaoTecnico() {
        clicar(SELETOR_BOTAO_TECNICO);
    }
    public static void clicarBotaoTecnicoFeedback() {
        clicar(SELETOR_BOTAO_TECNICO_FEEDBACK);
    }
    public void clicarBotaoVoltar() {
        clicar(SELETOR_BOTAO_VOLTAR);
    }
    public String consultarNomeUsuarioLogado() {
        esperarConteudoNaoVazio(SELETOR_NOME_USUARIO);
        return consultarTexto(SELETOR_NOME_USUARIO).toLowerCase();
    }
    public static String consultarTituloAtual() {
        esperarConteudoNaoVazio(SELETOR_TITULO_ATUAL);
        return consultarTexto(SELETOR_TITULO_ATUAL).toLowerCase();
    }

    public void acessarPagina() {
        DashboardPage.acessarPagina();
    }
}
