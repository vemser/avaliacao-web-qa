package br.com.dbccompany.vemser.pages;

import br.com.dbccompany.vemser.utils.Elementos;

public class MenuPage extends Elementos {
    private static final String SELETOR_NOME_USUARIO = "div.MuiDrawer-docked > div > aside > div.MuiBox-root > p > span > strong";
    private static final String SELETOR_BOTAO_ACOMPANHAMENTOS = "[data-testid=\"acompanhamentos-menu-btn\"]";
    private static final String SELETOR_BOTAO_COMPORTAMENTAL = "[data-testid=\"AssignmentIndIcon\"]";
    private static final String SELETOR_BOTAO_CONFIGURACOES = "[data-testid=\"configuracoes-menu-btn\"]";
    private static final String SELETOR_BOTAO_DASHBOARD = "[data-testid=\"dashboard-menu-btn\"]";
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
