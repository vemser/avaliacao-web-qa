package br.com.dbccompany.vemser.pages;

import br.com.dbccompany.vemser.utils.Elementos;

public class AcompanhamentosPage extends Elementos {
    public static final String URL_PAGINA = URL_BASE + "/avaliacao-front/comportamental/acompanhamentos";
    public void acessarPagina() {
        acessarUrl(URL_PAGINA);
    }
    public boolean estaNaPaginaDashboard() {
        return driver.getCurrentUrl().equals(URL_PAGINA);
    }
}
