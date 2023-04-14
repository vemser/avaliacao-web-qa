package br.com.dbccompany.vemser.pages;

import br.com.dbccompany.vemser.utils.Elementos;

public class EstagiariosPage extends Elementos {
    private static final String SELETOR_BOTAO_CADASTRO_ESTAGIARIO = "[data-testid=\"AddOutlinedIcon\"]";
    private static final String SELETOR_CAMPO_BUSCAR_NOME_ESTAGIARIO = "[id=\"nome\"]";
    public static final String URL_PAGINA = URL_BASE + "/avaliacao-front/estagiarios";
    public void acessarPagina() {
        acessarUrl(URL_PAGINA);
    }
    public void clicarBotaoCadastroEstagiario() {
        clicar(SELETOR_BOTAO_CADASTRO_ESTAGIARIO);
    }
    public boolean estaNaPaginaDashboard() {
        esperarUrl(URL_PAGINA);
        return driver.getCurrentUrl().equals(URL_PAGINA);
    }
}
