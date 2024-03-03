package br.com.dbccompany.vemser.pages;

import br.com.dbccompany.vemser.utils.Elementos;

import static br.com.dbccompany.vemser.pages.AcessoPage.URL_SITE;

public class ConfiguracoesPage extends Elementos {
    private static final String BTN_ACOMPANHAMENTOS_CONFIG = "[data-testid=\"acompanhamentos-config-btn\"]";
    private static final String BTN_CRIAR_ACOMPANHAMENTO = "[data-testid='programas-create-btn']";
    private static final String BTN_PROGRAMAS_CONFIG = "[data-testid=\"programas-config-btn\"]";
    private static final String BTN_CRIAR_PROGRAMA = "[data-testid=\"programas-create-btn\"]";
    private static final String BTN_VOLTAR = "[data-testid=\"programa-create-voltar-btn\"]";
    private static final String VALIDATOR_PROGRAMA = "#nome";
    private static final String VALIDATOR_ACOMPANHAMENTO = "#titulo";
    public static final String URL_PAGINA = URL_SITE + "/configuracoes";

    // Interaçãoes de CLICAR
    public void clicarBotaoAcompanhamentoConfig() {
        esperarElementoSerClicavel(BTN_ACOMPANHAMENTOS_CONFIG);
        clicar(BTN_ACOMPANHAMENTOS_CONFIG);
    }
    public void clicarBotaoProgramasConfig() {
        esperarElementoSerClicavel(BTN_PROGRAMAS_CONFIG);
        clicar(BTN_PROGRAMAS_CONFIG);
    }
    public void clicarBtnCriarAcompanhamentos() {
        esperarElementoSerClicavel(BTN_CRIAR_ACOMPANHAMENTO);
        clicar(BTN_CRIAR_ACOMPANHAMENTO);
    }
    public void clicarBtnCriarPrograma() {
        esperarElementoSerClicavel(BTN_CRIAR_PROGRAMA);
        clicar(BTN_CRIAR_PROGRAMA);
    }
    public void clicarVoltar() {
        clicar(BTN_VOLTAR);
    }

    // Validar elementos na tela VISIBILIDADE
    public boolean validarProgramas(){

        return estaVisivel(VALIDATOR_PROGRAMA);
    }
    public boolean validarAcompanhamentos(){
        esperarElementoSerClicavel(VALIDATOR_ACOMPANHAMENTO);
        return estaVisivel(VALIDATOR_ACOMPANHAMENTO);
    }
    public boolean validaPaginaConfiguracoes() {
        return consultarUrl().equals(URL_PAGINA);
    }

    // Métodos completos

    public boolean validarElementoProgramaEmPageConfig(){
        clicarBotaoProgramasConfig();
        clicarBtnCriarPrograma();
        return validarProgramas();
    }

    public boolean validarElementoAcompanhamentoEmPageConfig(){
        clicarBotaoAcompanhamentoConfig();
        clicarBtnCriarAcompanhamentos();
        return validarAcompanhamentos();
    }



}
