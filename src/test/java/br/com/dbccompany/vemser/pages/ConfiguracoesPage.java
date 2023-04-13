package br.com.dbccompany.vemser.pages;

import br.com.dbccompany.vemser.utils.Elementos;

public class ConfiguracoesPage extends Elementos {
    private static final String SELETOR_BOTAO_ACOMPANHAMENTOS_CONFIG = "[data-testid=\"acompanhamentos-config-btn\"]";
    private static final String SELETOR_BOTAO_PROGRAMAS_CONFIG = "[data-testid=\"programas-config-btn\"]";
    private static final String SELETOR_BOTAO_TRILHAS_CONFIG = "[data-testid=\"trilhas-config-btn\"]";
    public static final String URL_PAGINA = URL_BASE + "/avaliacao-front/configuracoes";
    public void acessarPagina() {
        acessarUrl(URL_PAGINA);
    }
    public void clicarBotaoAcompanhamentosConfig() {
        clicar(SELETOR_BOTAO_ACOMPANHAMENTOS_CONFIG);
    }
    public void clicarBotaoProgramasConfig() {
        clicar(SELETOR_BOTAO_PROGRAMAS_CONFIG);
    }
    public void clicarBotaoTrilhasConfig() {
        clicar(SELETOR_BOTAO_TRILHAS_CONFIG);
    }
    public boolean estaNaPaginaDashboard() {
        return driver.getCurrentUrl().equals(URL_PAGINA);
    }
}
