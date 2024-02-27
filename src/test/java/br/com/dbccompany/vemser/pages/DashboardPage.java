package br.com.dbccompany.vemser.pages;

import br.com.dbccompany.vemser.utils.Elementos;

public class DashboardPage extends Elementos {
    private static final String SELETOR_DASHBOARD_HEADER = "[data-testid=\"dashboard-header\"]";
    private static final String SELETOR_CAMPO_FILTRO_NOME = "[data-testid=\"textfield-nome-dashboard\"]";
    public static final String URL_PAGINA = URL_BASE + "/avaliacao-front";

    public static void acessarPagina() {
        acessarUrl(URL_PAGINA);
    }
    public boolean estaNaPaginaDashboard() {
        esperarUrl(URL_PAGINA);
        return driver.getCurrentUrl().equals(URL_PAGINA);
    }
}
